package si.um.feri.aiv.DSDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OsebaDao {
	
	DataSource baza;
	
	public OsebaDao(DataSource ds) throws Exception {
		baza=ds;
		//2. opcija:
		//baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");
		kreirajTabele();
	}
	
	public void kreirajTabele() throws Exception {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			conn.createStatement().execute("create table if not exists oseba(id int auto_increment, ime varchar, priimek varchar)");
//			conn.createStatement().execute("create table oseba(id int auto_increment, ime varchar(255), priimek varchar(255), primary key (id))");
		} finally {
			if (conn!=null) conn.close();
		}
	}
	
	public Oseba najdi(int id) throws Exception {
		Oseba ret=null;
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from oseba where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ret=new Oseba(rs.getString("ime"),rs.getString("priimek"),rs.getInt("id"));
				break;
			}
		} finally {
			conn.close();
		}
		return ret;
	}
	
	public void shrani(Oseba o) throws Exception {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			if (najdi(o.getId())!=null) {
				PreparedStatement ps=conn.prepareStatement("update oseba set ime=? , priimek=? where id=?");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setInt(3, o.getId());
				ps.executeUpdate();
			} else {
				PreparedStatement ps=conn.prepareStatement("insert into oseba(ime , priimek ) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.executeUpdate();
				//get generated ID
				ResultSet res = ps.getGeneratedKeys();
				while (res.next())
					o.setId(res.getInt(1));
				res.close();
			}
		} finally {
			conn.close();
		}
	}
	
	public List<Oseba> vrniVse() throws Exception {
		List<Oseba> ret=new ArrayList<Oseba>();
		Connection conn=null;
		try {
			conn=baza.getConnection();
			ResultSet rs=conn.createStatement().executeQuery("select * from oseba");
			while (rs.next()) {
				Oseba o=new Oseba(rs.getString("ime"),rs.getString("priimek"),rs.getInt("id"));
				ret.add(o);
			}
			rs.close();
		} finally {
			conn.close();
		}
		return ret;
	}

}
