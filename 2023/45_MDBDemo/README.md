# MDB Demo

*Precondition: server configuration*

Example:
```
<subsystem xmlns="urn:jboss:domain:ejb3:9.0">
...
    <mdb>
        <resource-adapter-ref resource-adapter-name="${ejb.resource-adapter-name:activemq-ra.rar}"/>
        <bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
    </mdb>
```