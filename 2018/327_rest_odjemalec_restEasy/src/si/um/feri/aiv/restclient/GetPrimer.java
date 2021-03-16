package si.um.feri.aiv.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class GetPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";
			
	public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println(status);
        System.out.println(value);

	}

}
