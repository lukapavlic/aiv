# Uporaba podatkovnega vira v DAO vzorcu - primer na WildFly (testirano na 8.2, 9 in 10)

Primer povezovanja na podatkovne vire aplikacijskega strežnika. V primeru uporabimo kar demo podatkovni vir na vgrajeni podatkovni bazi H2.

Iz upravljanega zrna se lahko povežemo z uporabo oznake:

@Resource(lookup="java:jboss/datasources/ExampleDS")
DataSource baza;

Sicer pa je možna pridobitev podatkovnega vira tudi preko JNDI poizvedbe:

baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");

Primer demonstrira tudi preklop podatkovne baze na MySql, pridobivanje generiranega identifikatorja in uporabo UTF8 pri spletnih obrazcih (šumniki...).

OPOMBA: V primeru se v tabelo (h:dataTable) preko get metode prenesejo podatki neposredno iz podatkovne baze (proženje poizvedbe v getterju). Ker implementacije gradnikov ne garantirajo, kolikokrat bodo poklicale get metodo, je to neučinkovita rešitev. Leša rešitev je demonstrirana tukaj: https://github.com/lukapavlic/aiv17/tree/master/011_jsfOsebe

V tem primeru se branje iz podatkovne baze izvede le pri prvem klicu getterja iste zahteve - nato se uporabijo predpomnjeni podatki.
