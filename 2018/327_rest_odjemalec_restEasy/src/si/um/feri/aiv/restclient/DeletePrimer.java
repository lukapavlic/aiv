package si.um.feri.aiv.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DeletePrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba/nekdo23@nekaj.si";

	public static void main(String[] args) throws Exception {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);

		Response response = target.request().delete();
		String value = response.readEntity(String.class);
		int status = response.getStatus();
		response.close();

		System.out.println(status);
		System.out.println(value);
		
	}

}
