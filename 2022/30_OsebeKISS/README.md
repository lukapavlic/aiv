# OsebeKISS
Maven spletni Jakarta EE (JSF) projekt - Osebe, Kontakti, OsebeDao (Memory, MySql, JPA), CRUD


Mail konfiguracija:
```
<mail-session name="UMMail" debug="true" jndi-name="java:jboss/mail/UMMail" from="ime.priimek@um.si">
    <smtp-server outbound-socket-binding-ref="mail-smtp-um" tls="true" username="ime.priimek@um.si" password="g3sl0"/>
</mail-session>
       
....

<outbound-socket-binding name="mail-smtp-um">
    <remote-destination host="mail.um.si" port="587"/>
</outbound-socket-binding>         
```
