package si.um.feri.aiv.proxyframework;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import si.um.feri.aiv.vao.Oseba;

public class PostPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";

	public static void main(String[] args) {

		ResteasyWebTarget rt = (ResteasyWebTarget) ClientBuilder.newClient().target(url);
		OsebeProxy osebeRest = rt.proxy(OsebeProxy.class);

		Oseba o=new Oseba("Palcek","Smuk","palcek@smuk.si");
		Jsonb jsonb = JsonbBuilder.create();	
		Response r = osebeRest.dodajOseboString(jsonb.toJson(o));
	
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(String.class));

		//2.
		r = osebeRest.dodajOsebo(new Oseba("Dobra","Vila","dobra@vile.si"));
		
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(String.class));
		
	}

}
