package si.um.feri.aiv.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

public class OsebaMySqlDao implements OsebaDao {

	Logger log=LoggerFactory.getLogger(OsebaMySqlDao.class);
	
	DataSource baza;
	
	private static OsebaMySqlDao instance=new OsebaMySqlDao();
	public static OsebaMySqlDao getInstance() {
		return instance;
	}
	
	private OsebaMySqlDao() {
		try {
			baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/mysqlds");
			kreirajTabele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void kreirajTabele() throws Exception {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			
			conn.createStatement().execute(
					"create table oseba("
					+ "ime varchar(50), "
					+ "priimek varchar(50), "
					+ "email varchar(50), "
					+ "cas timestamp, "
					+ "primary key (email))");
			
			conn.createStatement().execute(
					"create table kontakt("
					+ "id int auto_increment, "
					+ "tip varchar(20), "
					+ "naziv varchar(50), "
					+ "urejanje char(1), "
					+ "oseba varchar(50), "
					+ "primary key (id))");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	private List<Kontakt> vrniVseKontakte(String email,Connection conn) throws Exception {
		log.info("DAO: vračam vse kontakte osebe "+email);
		List<Kontakt> ret = new ArrayList<Kontakt>();

		PreparedStatement ps = conn.prepareStatement("select * from kontakt where oseba=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Kontakt k = new Kontakt(rs.getString("tip"), rs.getString("naziv"));
			k.setUrejanje(rs.getString("urejanje").equals("Y"));
			k.setId(rs.getInt("id"));
			ret.add(k);
		}
		rs.close();
		
		return ret;
	}

	@Override
	public List<Oseba> vrniVse() throws Exception {
		log.info("DAO: vračam vse");
		List<Oseba> ret = new ArrayList<Oseba>();
		Connection conn=null;
		try {
			conn=baza.getConnection();

			ResultSet rs=conn.createStatement().executeQuery("select * from oseba");
			while (rs.next()) {
				Oseba o = new Oseba(rs.getString("ime"), rs.getString("priimek"), rs.getString("email"));
				o.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				o.getKontakti().addAll(vrniVseKontakte(o.getEmail(), conn));
				ret.add(o);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}
	
	@Override
	public Oseba najdi(String email) throws Exception {
		log.info("DAO: iščem "+email);
		Oseba ret = null;
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from oseba where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new Oseba(rs.getString("ime"), rs.getString("priimek"), email);
				ret.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				ret.getKontakti().addAll(vrniVseKontakte(ret.getEmail(), conn));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}
	
	@Override
	public void shrani(Oseba o) throws Exception {
		log.info("DAO: shranjujem "+o);
		Connection conn=null;
		try {
			conn=baza.getConnection();
			if (najdi(o.getEmail()) != null) {
				PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=? , cas=? where email=?");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setTimestamp(3, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.setString(4, o.getEmail());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into oseba(ime , priimek, email, cas ) values (?,?,?,?)");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setString(3, o.getEmail());
				o.setDatumVpisa(new GregorianCalendar());
				ps.setTimestamp(4, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}	
	}
	
	@Override
	public void izbrisi(String email) throws Exception {
		log.info("DAO: brišem "+email);
		Connection conn=null;
		try {
			conn=baza.getConnection();

			PreparedStatement ps = conn.prepareStatement("delete from oseba where email=?");
			ps.setString(1, email);
			ps.executeUpdate();

			ps = conn.prepareStatement("delete from kontakt where oseba=?");
			ps.setString(1, email);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	private void izbrisiKontakt(int idKontakta, String emailOsebe,Connection conn) throws Exception {
		PreparedStatement ps = conn.prepareStatement("delete from kontakt where id=?");
		ps.setInt(1, idKontakta);
		ps.executeUpdate();
	}
	
	public void izbrisiKontakt(int idKontakta, String emailOsebe) throws Exception {
		log.info("DAO: brišem kontakt "+idKontakta+" osebe "+emailOsebe);
		Connection conn=null;
		try {
			conn=baza.getConnection();
			izbrisiKontakt(idKontakta,emailOsebe,conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	@Override
	public void shraniKontakt(Kontakt k, String emailOsebe) throws Exception {
		log.info("DAO: shranjujem kontakt "+k+" osebi "+emailOsebe);
		Connection conn=null;
		try {
			conn=baza.getConnection();
		
			izbrisiKontakt(k.getId(), emailOsebe, conn);
			
			PreparedStatement ps = conn.prepareStatement("insert into kontakt(tip , naziv, oseba, urejanje) values (?,?,?,?)");
			ps.setString(1, k.getTip());
			ps.setString(2, k.getNaziv());
			ps.setString(3, emailOsebe);
			ps.setString(4, k.isUrejanje()?"Y":"N");
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}	
	}

}