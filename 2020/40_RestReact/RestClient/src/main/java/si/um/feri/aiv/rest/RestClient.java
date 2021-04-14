package si.um.feri.aiv.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class RestClient {

	protected static String URL = "http://localhost:8080/RestService/rest/osebe";

	protected OsebeProxy osebeRest;
	
	public RestClient() {
		Client client=ClientBuilder.newClient();
		client.register(JacksonJaxbJsonProvider.class);
		ResteasyWebTarget rt = (ResteasyWebTarget) client.target(URL);
		osebeRest = rt.proxy(OsebeProxy.class);
	}
	
	public OsebeProxy osebeRest() {
		return osebeRest;
	}
	
}
