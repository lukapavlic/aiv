# Projekt, ki demonstrira sporoèilna zrna

V prijektu je veè sporoèilnih zrn:
- **AIVMessageDriven** (prijavljen na vrsto: jms/queue/test)
- **AIVMessageDrivenTopic** (prijavljen na vrsto: jms/topic/test)
- **VrstaBean** (prijavljen na vrsto: jms/queue/test)

Zrno VrstaBean demonstrira J2EE naèrtovalski vzorec **"Service Activator"** - odjemalcem omogoèa asinhrono proženje EJB metode Zrno.metoda().


*Predpogoji: na strežniku je potrebno aktivirati dodatek JMS (v WildFly 11 je to ActiveMQ), dodati sporoèilne vrste in teme ter dodati aplikacijskega uporabnika.*