package si.um.feri.aiv.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PostPrimer extends ACUtils {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba";
		
	private static String json = "{\"ime\":\"Peter\",\"priimek\":\"Klepec\",\"email\":\"nekdo23@nekaj.si\",\"datumVpisa\":1522792800000,\"bivalisce\":{\"koda\":\"2000\",\"naziv\":\"Maribor\"}}";
	
	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
				
	    StringEntity entity = new StringEntity(json);
	    request.setEntity(entity);
	    request.setHeader("Accept", "application/json");
	    request.setHeader("Content-type", "application/json");
	 
		HttpResponse response = client.execute(request);

		printResponse(response);

	}

}
