package si.um.feri.aiv.proxyframework;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class DeletePrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";

	public static void main(String[] args) {

		ResteasyWebTarget rt = (ResteasyWebTarget) ClientBuilder.newClient().target(url);
		OsebeProxy osebeRest = rt.proxy(OsebeProxy.class);
		
		Response r = osebeRest.izbrisiOsebo("palcek@smuk.si");
		
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(String.class));
		
	}

}
