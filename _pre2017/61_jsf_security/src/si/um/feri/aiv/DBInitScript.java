package si.um.feri.aiv;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DBInitScript {

	public static final String CREATE_USER_TABLE="CREATE TABLE user(username VARCHAR(64) PRIMARY KEY, passwd VARCHAR(64));";
	public static final String CREATE_ROLES_TABLE="CREATE TABLE role(username VARCHAR(64), userRoles VARCHAR(32));";
	public static final String INSERT_USER="INSERT INTO user(username, passwd) values ";
	public static final String GRANT_USER="INSERT INTO role(username, userRoles) values ";

	public static final boolean HASH_PASSWORD=false;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		System.out.println(CREATE_USER_TABLE);
		System.out.println(CREATE_ROLES_TABLE);
		
		String [] users={"user1","user2","user3"};
		String [] passwords={getPass("user1"),getPass("user2"),getPass("user3")};
		String [] roles={"admin","user","readonly"};
		
		System.out.println(INSERT_USER+"('"+users[0]+"','"+passwords[0]+"');");
		System.out.println(INSERT_USER+"('"+users[1]+"','"+passwords[1]+"');");
		System.out.println(INSERT_USER+"('"+users[2]+"','"+passwords[2]+"');");
		
		System.out.println(GRANT_USER+"('"+users[0]+"','"+roles[0]+"');");
		System.out.println(GRANT_USER+"('"+users[1]+"','"+roles[1]+"');");
		System.out.println(GRANT_USER+"('"+users[2]+"','"+roles[2]+"');");
	}
	
	public static String getPass(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		md.update(pass.getBytes());
		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
}
