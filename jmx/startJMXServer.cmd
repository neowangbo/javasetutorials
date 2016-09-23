# start JMX server
# URL = service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi
java -cp target\jmx.jar -Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false com.martian.apps.javasetutorials.jmx.HelloMBeanServer