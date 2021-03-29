# Konzolna aplikacija, ki demonstrira povezovanje na JMS

*Predpogoji: na strezniku je potrebno aktivirati dodatek JMS , dodati sporocilne vrste in teme ter dodati aplikacijskega uporabnika.*

 - < jms-queue name="testQueue" entries="jms/queue/test java:jboss/exported/jms/queue/test"/ >

 - < jms-topic name="testTopic" entries="jms/topic/test java:jboss/exported/jms/topic/test"/ >

 
 Za delo brez prijave:
 
 ```
  <subsystem xmlns="urn:jboss:domain:messaging-activemq:12.0">
             <server name="default">
           ...
			 <security enabled="false"/>
			 ...
 
 ```