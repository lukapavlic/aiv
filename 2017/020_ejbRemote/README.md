# EJB - osnovni primer

Primer demonstrira 2 EJB zrni. Demo ima le oddaljen vmesnik, Calculator pa tako oddaljenega kot lokalnega

Nanju se povežemo preko poizvedbe v JNDI imeniku (Context.lookup). Povezava med zrni pa je izvedena s pomoèjo oznake @EJB.

Pazite: za pravilno delovanje zgodovine raèunanja, bi moral EJB CalculatorBean biti **Stateful!**

Predpogoji za oddaljeno povezovanje na EJB: podatki za povezovanje na JNDI v datoteki **jndi.properties** in Wildfly odjemalec (jboss-client.jar - najdete ga v wildfly-10.1.0.Final\bin\client).
