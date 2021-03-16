package si.um.feri.aiv.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetPrimer extends ACUtils {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";
			
	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		printResponse(response);

	}

}
