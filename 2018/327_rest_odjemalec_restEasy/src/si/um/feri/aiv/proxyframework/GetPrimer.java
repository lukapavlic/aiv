package si.um.feri.aiv.proxyframework;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import si.um.feri.aiv.vao.Oseba;

public class GetPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";

	public static void main(String[] args) {

		ResteasyWebTarget rt = (ResteasyWebTarget) ClientBuilder.newClient().target(url);
		OsebeProxy osebeRest = rt.proxy(OsebeProxy.class);
		
		Response r = osebeRest.vrniVseOsebe();
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(String.class));

		//2.
		System.out.println(osebeRest.vrniOsebo("krpan@gmail.com"));
		
		//3.
		r=osebeRest.vrniOseboResponse("krpan@gmail.com");
		Jsonb jsonb = JsonbBuilder.create();
		Oseba o=jsonb.fromJson(r.readEntity(String.class), Oseba.class);
		System.out.println(o);
		
	}

}
