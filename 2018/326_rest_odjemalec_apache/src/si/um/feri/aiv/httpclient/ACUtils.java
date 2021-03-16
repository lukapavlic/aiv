package si.um.feri.aiv.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;

public class ACUtils {

	public static void printResponse(HttpResponse response) throws Exception {
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result);
	}
	
}
