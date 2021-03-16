# Konzolna aplikacija, ki demonstrira povezovanje na JMS

*Predpogoji: na strežniku je potrebno aktivirati dodatek JMS , dodati sporocilne vrste in teme ter dodati aplikacijskega uporabnika.*

 - < jms-queue name="testQueue" entries="jms/queue/test java:jboss/exported/jms/queue/test"/ >

 - < jms-topic name="testTopic" entries="jms/topic/test java:jboss/exported/jms/topic/test"/ >
