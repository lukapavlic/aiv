package si.um.feri.aiv.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PutPrimer extends ACUtils {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba/nekdo23@nekaj.si";

	private static String json = "{\"ime\":\"Novo Ime Peter\",\"priimek\":\"Klepec\",\"email\":\"nekdo23@nekaj.si\",\"datumVpisa\":\"2017-04-05T01:00:00+02:00[Europe/Ljubljana]\",\"bivalisce\":{\"koda\":\"2000\",\"naziv\":\"Maribor\"}}";
	
	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPut request = new HttpPut(url);

	    StringEntity entity = new StringEntity(json);
	    request.setEntity(entity);
	    request.setHeader("Accept", "application/json");
	    request.setHeader("Content-type", "application/json");
	 
		HttpResponse response = client.execute(request);

		printResponse(response);

	}

}
