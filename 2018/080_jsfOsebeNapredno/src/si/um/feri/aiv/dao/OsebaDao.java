package si.um.feri.aiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

/**
 * Trajno hranjenje objektov Oseba
 * Edinec
 */
public class OsebaDao extends Dao<Oseba> {

	private OsebaDao() {
		//jdbc:mysql://localhost:3306/aiv
		super("java:jboss/datasources/aiv",
				   "create table oseba(id int auto_increment, ime varchar(255), priimek varchar(255), spol varchar(10), cas timestamp, rojstvo timestamp, primary key (id))");
//		super("java:jboss/datasources/ExampleDS",
//			   "create table if not exists oseba(id int auto_increment, ime varchar, priimek varchar, spol varchar, cas timestamp, rojstvo timestamp)");
	}
	
	private static OsebaDao inst=new OsebaDao();
	
	public static OsebaDao getInstance() {
		return inst;
	}

	@Override
	public Oseba najdi(int id,Connection conn) throws Exception {
		log.info("Iščem osebo "+id);
		Oseba ret = null;
		PreparedStatement ps = conn.prepareStatement("select * from oseba where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ret = new Oseba(rs.getString("ime"), rs.getString("priimek"));
			ret.setId(id);
			ret.setSpol(rs.getString("spol"));
			ret.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
			ret.getDatumRojstva().setTimeInMillis(rs.getTimestamp("rojstvo").getTime());
			break;
		}
		if (ret!=null) ret.setKontakti(KontaktDao.getInstance().vrniVse(id,conn));
		return ret;
	}
	
	@Override
	public void shrani(Oseba o,Connection conn) throws Exception {
		log.info("Shranjujem osebo "+o);
		if (o==null) return;
		if (najdi(o.getId()) != null) {
			PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=? , cas=? , rojstvo = ? , spol = ? where id=?");
			ps.setString(1, o.getIme());
			ps.setString(2, o.getPriimek());
			ps.setTimestamp(3, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
			ps.setTimestamp(4, new Timestamp(o.getDatumRojstva().getTimeInMillis()));
			ps.setString(5, o.getSpol());
			ps.setInt(6, o.getId());
			ps.executeUpdate();
		} else {
			PreparedStatement ps = conn.prepareStatement("insert into oseba(ime , priimek, cas, rojstvo, spol ) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getIme());
			ps.setString(2, o.getPriimek());
			o.setDatumVpisa(new GregorianCalendar());
			ps.setTimestamp(3, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
			ps.setTimestamp(4, new Timestamp(o.getDatumRojstva().getTimeInMillis()));
			ps.setString(5, o.getSpol());
			ps.executeUpdate();
			//pridobivanje generiranega IDja
			ResultSet res = ps.getGeneratedKeys();
			while (res.next())
				o.setId(res.getInt(1));
			res.close();
		}
		for (Kontakt k:o.getKontakti())
			KontaktDao.getInstance().shrani(k,conn);
	}

	@Override
	public List<Oseba> vrniVse(Connection conn) throws Exception {
		log.info("Vračam vse osebe!");
		List<Oseba> ret = new ArrayList<Oseba>();
		ResultSet rs=conn.createStatement().executeQuery("select * from oseba");
		while (rs.next()) {
			Oseba o = new Oseba(rs.getString("ime"), rs.getString("priimek"));
			o.setId(rs.getInt("id"));
			o.setSpol(rs.getString("spol"));
			o.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
			o.getDatumRojstva().setTimeInMillis(rs.getTimestamp("rojstvo").getTime());
			o.setKontakti(KontaktDao.getInstance().vrniVse(o.getId(),conn));
			ret.add(o);
		}
		rs.close();
		return ret;
	}

}