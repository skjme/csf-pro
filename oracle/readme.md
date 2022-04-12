### api
```shell
curl localhost:88/?empno=7369
```

### druid
http://localhost:88/druid/index.html


### db config
> myoracle 本地映射实际地址
> orcl11g.us.oracle.com 服务名
```properties
#Basic Spring Boot Config for Oracle
spring.datasource.url= jdbc:oracle:thin:@//myoracle:1521/orcl11g.us.oracle.com
spring.datasource.username=scott
spring.datasource.password=tiger
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.max-idle=10
spring.datasource.max-wait=10000
spring.datasource.min-idle=5
spring.datasource.initial-size=5
```


### db-server查看监听
```shell
[oracle@hwcloud ~]$ lsnrctl status

LSNRCTL for Linux: Version 11.2.0.4.0 - Production on 12-APR-2022 12:56:36

Copyright (c) 1991, 2013, Oracle.  All rights reserved.

Connecting to (DESCRIPTION=(ADDRESS=(PROTOCOL=IPC)(KEY=EXTPROC1521)))
STATUS of the LISTENER
------------------------
Alias                     LISTENER
Version                   TNSLSNR for Linux: Version 11.2.0.4.0 - Production
Start Date                11-APR-2022 20:21:54
Uptime                    0 days 16 hr. 34 min. 42 sec
Trace Level               off
Security                  ON: Local OS Authentication
SNMP                      OFF
Listener Parameter File   /u01/app/oracle/product/11.2.0/db_1/network/admin/listener.ora
Listener Log File         /u01/app/oracle/diag/tnslsnr/hwcloud/listener/alert/log.xml
Listening Endpoints Summary...
  (DESCRIPTION=(ADDRESS=(PROTOCOL=ipc)(KEY=EXTPROC1521)))
  (DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=hwcloud)(PORT=1521)))
Services Summary...
Service "orcl11g.us.oracle.com" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
Service "orclXDB.us.oracle.com" has 1 instance(s).
  Instance "orcl", status READY, has 1 handler(s) for this service...
The command completed successfully

```