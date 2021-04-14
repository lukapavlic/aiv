package si.um.feri.aiv.rest;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		fillCors(responseContext.getHeaders());
	}
	
	public static void fillCors(MultivaluedMap<String, Object> m) {
		m.add("Access-Control-Allow-Origin", "*");
		m.add("Access-Control-Allow-Credentials", "true");
		m.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, API-Key, User-Id");
		m.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}
	
}
