package si.um.feri.aiv.proxyframework;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import si.um.feri.aiv.vao.Oseba;
import si.um.feri.aiv.vao.Posta;

public class PutPrimer {

	private static String url = "http://localhost:8080/325_rest_storitev/rest/osebe";

	public static void main(String[] args) {

		ResteasyWebTarget rt = (ResteasyWebTarget) ClientBuilder.newClient().target(url);
		OsebeProxy osebeRest = rt.proxy(OsebeProxy.class);
		
		Oseba o=new Oseba("Novo Ime Peter", "Klepec", "nekdo@nekaj.si");
		o.setBivalisce(new Posta());
		o.getBivalisce().setKoda("2000");
		o.getBivalisce().setNaziv("Maribor");
		
		Response r = osebeRest.spremeniOsebo("nekdo@nekaj.si",o);
		
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(String.class));
		
	}

}
