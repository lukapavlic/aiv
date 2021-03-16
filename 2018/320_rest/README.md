# JAX-RS

Osnovni primer - registracija servleta v web.xml:

	<servlet-mapping>
		<servlet-name>javax.ws.rs.core.Application</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>
	
Odjemalec je osnoven java.net.URLConnection

