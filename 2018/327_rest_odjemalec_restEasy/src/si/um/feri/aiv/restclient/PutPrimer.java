package si.um.feri.aiv.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PutPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe/oseba/nekdo23@nekaj.si";

	private static String json = "{\"ime\":\"Novo Ime Peter\",\"priimek\":\"Klepec\",\"email\":\"nekdo23@nekaj.si\",\"datumVpisa\":\"2018-04-04T01:00:00+02:00[Europe/Ljubljana]\",\"bivalisce\":{\"koda\":\"2000\",\"naziv\":\"Maribor\"}}";
	
	public static void main(String[] args) throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

        Response response = target.request().put(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println(status);
        System.out.println(value);	

	}

}
