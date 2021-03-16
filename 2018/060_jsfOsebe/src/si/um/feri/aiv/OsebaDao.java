package si.um.feri.aiv;

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

public class OsebaDao {

	Logger log=LoggerFactory.getLogger(OsebaDao.class);
	
	DataSource baza;

	public OsebaDao() {
		try {
			baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");	
			kreirajTabele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void kreirajTabele() throws Exception {
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			
			conn.createStatement().execute("create table if not exists jsfoseba2(ime varchar, priimek varchar, spol varchar, email varchar, cas timestamp, rojstvo timestamp)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public Oseba najdi(String email) throws Exception {
		log.info("DAO: išèem "+email);
		Oseba ret = null;
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from jsfoseba2 where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new Oseba(rs.getString("ime"), rs.getString("priimek"), email);
				ret.setSpol(rs.getString("spol"));
				ret.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				ret.getDatumRojstva().setTimeInMillis(rs.getTimestamp("rojstvo").getTime());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

	public void shrani(Oseba o) throws Exception {
		log.info("DAO: shranjujem "+o);
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			if (najdi(o.getEmail()) != null) {
				PreparedStatement ps = conn.prepareStatement("update jsfoseba2 set ime=? , priimek=? , cas=? , rojstvo = ? , spol = ? where email=?");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setTimestamp(3, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.setTimestamp(4, new Timestamp(o.getDatumRojstva().getTimeInMillis()));
				ps.setString(5, o.getSpol());
				ps.setString(6, o.getEmail());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into jsfoseba2(ime , priimek, email, cas, rojstvo, spol ) values (?,?,?,?,?,?)");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setString(3, o.getEmail());
				o.setDatumVpisa(new GregorianCalendar());
				ps.setTimestamp(4, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.setTimestamp(5, new Timestamp(o.getDatumRojstva().getTimeInMillis()));
				ps.setString(6, o.getSpol());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public List<Oseba> vrniVse() throws Exception {
		log.info("DAO: vraèam vse");
		List<Oseba> ret = new ArrayList<Oseba>();
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();

			ResultSet rs=conn.createStatement().executeQuery("select * from jsfoseba2");
			while (rs.next()) {
				Oseba o = new Oseba(rs.getString("ime"), rs.getString("priimek"), rs.getString("email"));
				o.setSpol(rs.getString("spol"));
				o.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				o.getDatumRojstva().setTimeInMillis(rs.getTimestamp("rojstvo").getTime());
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

}