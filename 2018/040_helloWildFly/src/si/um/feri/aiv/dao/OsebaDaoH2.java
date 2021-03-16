package si.um.feri.aiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.Oseba;

/**
 * 	H2 DB
 */
public class OsebaDaoH2 extends OsebaDao {

	Logger log=LoggerFactory.getLogger(OsebaDaoH2.class);

	DataSource baza;

	public OsebaDaoH2() throws Exception {
		baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");
		kreirajTabele();
	}

	public void kreirajTabele() throws Exception {
		Connection conn = null;
		try {
			conn = baza.getConnection();
			String sql="create table if not exists oseba(id int auto_increment, ime varchar, priimek varchar)";
			log.info(sql);
			conn.createStatement().execute(sql);
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	@Override
	public Oseba najdiOsebo(int id) throws Exception {
		Oseba ret = null;
		Connection conn = null;
		log.info("Iscem osebo "+id);
		try {
			conn = baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from oseba where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new Oseba(rs.getInt("id"),rs.getString("ime"), rs.getString("priimek"));
				break;
			}
		} finally {
			conn.close();
		}
		return ret;
	}
	
	@Override
	public void shrani(Oseba o) throws Exception {
		Connection conn = null;
		log.info("Shranjujem "+o);
		try {
			conn = baza.getConnection();
			if (najdiOsebo(o.getId()) != null) {
				PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=? where id=?");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setInt(3, o.getId());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into oseba(ime , priimek ) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.executeUpdate();
				// get generated ID
				ResultSet res = ps.getGeneratedKeys();
				while (res.next())
					o.setId(res.getInt(1));
				res.close();
			}
		} finally {
			conn.close();
		}
	}
	
	@Override
	public List<Oseba> vrniVse() throws Exception {
		List<Oseba> ret = new ArrayList<Oseba>();
		Connection conn = null;
		log.info("Vraèam vse osebe.");
		try {
			conn = baza.getConnection();
			ResultSet rs = conn.createStatement().executeQuery("select * from oseba");
			while (rs.next()) {
				Oseba o = new Oseba(rs.getInt("id"), rs.getString("ime"), rs.getString("priimek"));
				ret.add(o);
			}
			rs.close();
		} finally {
			conn.close();
		}
		return ret;
	}
	
}
