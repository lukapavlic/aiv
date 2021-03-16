package si.um.feri.aiv.dao;

import java.sql.Connection;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Skupen nadrazred za DAO-te
 * Glavne fukcionalnosti (povezovanje, kreitanje tabel) so realizirane tukaj.
 * Konkretni DATti morajo implementirati abstraktne metode.
 *
 * @param <T> Razred, katerega trajno hranimo
 */
public abstract class Dao<T> {
	
	protected Logger log=LoggerFactory.getLogger(Dao.class);
	
	protected DataSource getBaza() throws Exception {
		return (DataSource)new InitialContext().lookup(jndi);
	}
	
	private String jndi;

	/**
	 * Inicializacija
	 * @param jndi - JNDI ime za pridobivanje podatkovnega vira
	 * @param createTable - SQL, ki se naj uporabi, če tabel v bazi še ni
	 */
	protected Dao(String jndi, String createTable) {
		log.info("New Dao: "+jndi);
		this.jndi=jndi;
		try {
			kreirajTabele(createTable);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace(System.out);
		}
	}
	
	private void kreirajTabele(String createTable) throws Exception {
		log.info(createTable);
		Connection conn=null;
		try {
			conn=getBaza().getConnection();
			conn.createStatement().execute(createTable);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	/**
	 * Iskanje objekta na podlagi id-ja
	 * @param id ID predvidevamo tipa int
	 * @return Objekt ali null, če ga ni
	 * @throws Exception
	 */
	public T najdi(int id) throws Exception {
		Connection conn=null;
		T ret=null;
		try {
			conn=getBaza().getConnection();
			ret=najdi(id,conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

	/**
	 * Iskanje objekta na podlagi id-ja
	 * @param id ID predvidevamo tipa int
	 * @return Objekt ali null, če ga ni
	 * @param conn Obstoječa povezava do baze
	 * @throws Exception
	 */
	public abstract T najdi(int id,Connection conn) throws Exception;
	
	/**
	 * Shranjevanje objekta
	 * Implementacija naj preveri, če objekt že obstaja. V tem primeru ga posodobimo
	 * Po shranjevanju naj objekt nosi aktualno vrednost ID-ja
	 * @param obj Objekt, ki ga shranjujemo
	 * @throws Exception
	 */
	public void shrani(T obj) throws Exception {
		log.info("Shranjujem "+obj);
		Connection conn=null;
		try {
			conn=getBaza().getConnection();
			shrani(obj,conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	/**
	 * Shranjevanje objekta
	 * Implementacija naj preveri, če objekt že obstaja. V tem primeru ga posodobimo
	 * Po shranjevanju naj objekt nosi aktualno vrednost ID-ja
	 * @param obj Objekt, ki ga shranjujemo
	 * @param conn Obstoječa povezava do baze
	 * @throws Exception
	 */
	public abstract void shrani(T obj,Connection conn) throws Exception;
	
	/**
	 * Vračanje kolekcije vseh objektov.
	 * Če objektov ni, vrnimo prazno kolekcijo
	 * @return Kolekcija (lahko tudi prazna)
	 * @throws Exception
	 */
	public List<T> vrniVse() throws Exception {
		Connection conn=null;
		List<T> ret=null;
		try {
			conn=getBaza().getConnection();
			ret=vrniVse(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

	/**
	 * Vračanje kolekcije vseh objektov.
	 * Če objektov ni, vrnimo prazno kolekcijo
	 * @return Kolekcija (lahko tudi prazna)
	 * @param conn Obstoječa povezava do baze
	 * @throws Exception
	 */
	public abstract List<T> vrniVse(Connection conn) throws Exception;

}