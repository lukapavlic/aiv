package si.um.feri.aiv.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PostPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba";
		
	private static String json = "{\"ime\":\"Peter\",\"priimek\":\"Klepec\",\"email\":\"nekdo23@nekaj.si\",\"datumVpisa\":1522792800000,\"bivalisce\":{\"koda\":\"2000\",\"naziv\":\"Maribor\"}}";
	
	public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

        Response response = target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println(status);
        System.out.println(value);		
		
	}

}
