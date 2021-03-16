package si.um.feri.aiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import si.um.feri.aiv.vao.Kontakt;

/**
 * Trajno hranjenje objektov Kontakt
 * Edinec
 */
public class KontaktDao extends Dao<Kontakt> {
	
	private KontaktDao() {
		//jdbc:mysql://localhost:3306/aiv
		super("java:jboss/datasources/aiv",
				"create table kontakt(id int auto_increment, tip varchar(20), email varchar(50), telefon varchar(50), oseba int, primary key (id))");
//		super("java:jboss/datasources/ExampleDS",
//				"create table if not exists kontakt(id int auto_increment, tip varchar, email varchar, telefon varchar, oseba int)");
	}

	private static KontaktDao inst=new KontaktDao();
	
	public static KontaktDao getInstance() {
		return inst;
	}
	
	@Override
	public Kontakt najdi(int id,Connection conn) throws Exception {
		log.info("Iščem kontakt "+id);
		Kontakt ret = null;
		PreparedStatement ps = conn.prepareStatement("select * from kontakt where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ret = new Kontakt(rs.getString("tip"), rs.getString("email"), rs.getString("telefon"));
			ret.setId(id);
			ret.setIdLastnika(rs.getInt("oseba"));
			break;
		}
		return ret;
	}
	
	@Override
	public void shrani(Kontakt o,Connection conn) throws Exception {
		log.info("Shranjujem kontakt "+o);
		if (o==null) return;
		if (najdi(o.getId()) != null) {
			PreparedStatement ps = conn.prepareStatement("update kontakt set tip=? , email=? , telefon = ? , oseba = ? where id=?");
			ps.setString(1, o.getTip());
			ps.setString(2, o.getEmail());
			ps.setString(3, o.getTelefon());
			ps.setInt(4, o.getIdLastnika());
			ps.setInt(5, o.getId());
			ps.executeUpdate();
		} else {
			PreparedStatement ps = conn.prepareStatement("insert into kontakt(tip , email, telefon, oseba ) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getTip());
			ps.setString(2, o.getEmail());
			ps.setString(3, o.getTelefon());
			ps.setInt(4, o.getIdLastnika());
			ps.executeUpdate();
			//pridobivanje generiranega IDja
			ResultSet res = ps.getGeneratedKeys();
			while (res.next())
				o.setId(res.getInt(1));
			res.close();
		}
	}
	
	@Override
	public List<Kontakt> vrniVse(Connection conn) throws Exception {
		throw new Exception("Not Yet Implemented");
	}
	
	public List<Kontakt> vrniVse(int idOsebe, Connection conn) throws Exception {
		log.info("Iščem kontakte osebe "+idOsebe);
		List<Kontakt> ret = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement("select * from kontakt where oseba=?");
		ps.setInt(1, idOsebe);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Kontakt k=new Kontakt(rs.getString("tip"), rs.getString("email"), rs.getString("telefon"));
			k.setIdLastnika(idOsebe);
			k.setId(rs.getInt("id"));
			ret.add(k);
		}
		return ret;
	}

}