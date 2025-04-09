# MDB Demo

*Precondition: server configuration*

Example:
```
<mdb>
    <resource-adapter-ref resource-adapter-name="${ejb.resource-adapter-name:activemq-ra.rar}"/>
    <bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
</mdb>
```