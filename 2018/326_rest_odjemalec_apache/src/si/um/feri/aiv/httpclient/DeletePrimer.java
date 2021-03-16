package si.um.feri.aiv.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

public class DeletePrimer extends ACUtils {
	
	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba/nekdo23@nekaj.si";
	
	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(url);
		HttpResponse response = client.execute(request);

		printResponse(response);

	}

}
