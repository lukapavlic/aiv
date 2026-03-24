# JMS demo


*Precondition: server configuration.*

```
<jms-queue name="testQueue" entries="jms/queue/test java:jboss/exported/jms/queue/test"/>
<jms-topic name="testTopic" entries="jms/topic/test java:jboss/exported/jms/topic/test"/>
```

Example (wildfly-31.0.1-Final)

```
<server>
    <extensions>
        ...
        <extension module="org.wildfly.extension.messaging-activemq"/>
        ...
    </extensions>
```

```
<subsystem xmlns="urn:jboss:domain:messaging-activemq:16.0">
        <server name="default">
        <!--security elytron-domain="ApplicationDomain"/-->
        <security enabled="false"/>
        <statistics enabled="${wildfly.messaging-activemq.statistics-enabled:${wildfly.statistics-enabled:false}}"/>
        <security-setting name="#">
                <role name="guest" send="true" consume="true" create-non-durable-queue="true" delete-non-durable-queue="true"/>
        </security-setting>
        <address-setting name="#" dead-letter-address="jms.queue.DLQ" expiry-address="jms.queue.ExpiryQueue" max-size-bytes="10485760" page-size-bytes="2097152" message-counter-history-day-limit="10"/>
        <http-connector name="http-connector" socket-binding="http" endpoint="http-acceptor"/>
        <http-connector name="http-connector-throughput" socket-binding="http" endpoint="http-acceptor-throughput">
                <param name="batch-delay" value="50"/>
        </http-connector>
        <in-vm-connector name="in-vm" server-id="0">
                <param name="buffer-pooling" value="false"/>
        </in-vm-connector>
        <http-acceptor name="http-acceptor" http-listener="default"/>
        <http-acceptor name="http-acceptor-throughput" http-listener="default">
                <param name="batch-delay" value="50"/>
                <param name="direct-deliver" value="false"/>
        </http-acceptor>
        <in-vm-acceptor name="in-vm" server-id="0">
                <param name="buffer-pooling" value="false"/>
        </in-vm-acceptor>
        <jms-queue name="ExpiryQueue" entries="java:/jms/queue/ExpiryQueue"/>
        <jms-queue name="DLQ" entries="java:/jms/queue/DLQ"/>
        <connection-factory name="InVmConnectionFactory" entries="java:/ConnectionFactory" connectors="in-vm"/>
        <connection-factory name="RemoteConnectionFactory" entries="java:jboss/exported/jms/RemoteConnectionFactory" connectors="http-connector"/>
        <pooled-connection-factory name="activemq-ra" entries="java:/JmsXA java:jboss/DefaultJMSConnectionFactory" connectors="in-vm" transaction="xa"/>
        </server>
</subsystem>
```


```
<mdb>
    <resource-adapter-ref resource-adapter-name="${ejb.resource-adapter-name:activemq-ra.rar}"/>
    <bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
</mdb>
```
