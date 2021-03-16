# JSF

Preprost primer aplikacije z ogrodjem JSF. Aplikacija vsebuje 3 vloge uporabnikov.

## Opcija 1: hramba uporabnikov v tekstovni datoteki:
application-roles.properties:

	user1=admin
	user2=user
	user3=readonly

application-users.properties:

	user1=6e388d2e45352e4133332118f40f3cec
	user2=1153cae2fa9913d32a64b22632be5f31
	user3=c05c164221104cd9a9be5588a6fa69a9

Gesla: user1, user2, user3


## Opcija 2: hramba uporabnikov v podatkovni bazi

	CREATE TABLE user(username VARCHAR(64) PRIMARY KEY, passwd VARCHAR(64));
	CREATE TABLE role(username VARCHAR(64), userRoles VARCHAR(32));
	INSERT INTO user(username, passwd) values ('user1','user1');
	INSERT INTO user(username, passwd) values ('user2','user2');
	INSERT INTO user(username, passwd) values ('user3','user3');
	INSERT INTO role(username, userRoles) values ('user1','admin');
	INSERT INTO role(username, userRoles) values ('user2','user');
	INSERT INTO role(username, userRoles) values ('user3','readonly');

Konfiguracija strežnika:

	<security-domain name="DBAuth">
		<authentication>
			<login-module code="org.jboss.security.auth.spi.DatabaseServerLoginModule" flag="required">
				<module-option name="dsJndiName" value="java:jboss/datasources/MyDS"/>
				<module-option name="principalsQuery" value="select passwd from user where username=?"/>
				<module-option name="rolesQuery" value="select userRoles, 'Roles' from role where  username=?"/>
			</login-module>
		</authentication>
	</security-domain>
	
Uporabimo lahko tudi gesla v hash obliki. Npr:

	<module-option name="hashAlgorithm" value="MD5" />
	<module-option name="hashEncoding" value="HEX" />
	


				