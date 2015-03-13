# Uporaba podatkovnega vira v DAO vzorcu - primer na WildFly 8.2

Primer povezovanja na podatkovne vire aplikacijskega strežnika. V primeru uporabimo kar demo podatkovni vir na vgrajeni podatkovni bazi H2.

Iz upravljanega zrna se lahko povežemo z uporabo oznake:

@Resource(lookup="java:jboss/datasources/ExampleDS")
DataSource baza;

Sicer pa je možna pridobitev podatkovnega vira tudi preko JNDI poizvedbe:

baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");