package si.um.feri.aiv.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Client {

	public static void main(String[] args) throws Exception {
		get("http://localhost:8080/320_rest/rest/osebejson");
		get("http://localhost:8080/320_rest/rest/osebejson/oseba/mojca@pravljice.si");
		get("http://localhost:8080/320_rest/rest/osebexml");
		get("http://localhost:8080/320_rest/rest/osebexml/oseba/mojca@pravljice.si");
	}
	
	public static void get(String u) throws Exception {
		URLConnection conn = new URL(u).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

}
