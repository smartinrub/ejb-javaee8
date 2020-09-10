# ejb-javaee8

This is a project to show how to use Enterprise Java Beans (EJBs) from Java EE.

## Technologies

- Maven
- Java EE (EJB)

## Getting Started

Both, EJBs and client, can be deployed in a web server like Glassfish or WildFly.

### Deployment on Glassfish

1. Install Payara (MacOS):

    ```
    brew install payara
    ```

2. Start Glassfish:

    ```
    asadmin start-domain --verbose domain
    ```
   
   >To use Payara server with MySQL you will have to download [Connector/J 5.1.49](https://dev.mysql.com/downloads/connector/j/5.1.html) and place it in `/usr/local/Cellar/payara/5.192/libexec/glassfish/lib`
   
3. Go to Payara administration console at `localhost:8080`. The first time it will ask you to set a password for the admin user.                                                                                                             
4. Build EJB beans and client application:

    ```
    mvn clean install
    ```

5. Deploy EJB beans and application: go to Applications>Deploy... and choose the file 
 `ejb-beans/target/ejb-beans-1.3.jar` to deploy the beans and `ejb-client/target/ejb-client.war` to deploy the client.
 
 >Glassfish version 5.1.0 has a bug in the deployment form (GUI internal error: Archive Path is NULL). 
 >The fix is either modifying the html in the browser or 
 >opening `/usr/local/Cellar/glassfish/5.1.0/libexec/glassfish/modules/console-common.jar` and
 > replace `<sun:form id="form">` with `<sun:form id="form" enctype="multipart/form-data">` in `applications/uploadFrame.jsf`.

 ```
 vi console-common.jar
 applications/uploadFrame.jsf
 ```

6. Go to the `ejb-client` configuration and change the context root to `/ejb-client`.
7. Access API:
```
http://localhost:8080/ejb-client/search
http://localhost:8080/ejb-client/fooChild
http://localhost:8080/ejb-client/count
```
   
### Deployment on WildFly

1. Install WildFly (MacOS):

    ```
    brew install wildfly-as
    ```
   
   Add to `.bash_profile` or `.zshrc`:
   
    ```
    export JBOSS_HOME=/usr/local/opt/wildfly-as/libexec
    export PATH=${PATH}:${JBOSS_HOME}/bin
    ```
   
2. Start Glassfish:

    ```
    brew services start wildfly-as
    ```

3. Go to `localhost:9990`
4. Build project and deploy beans and client. 
>Remember, WildFly 20 is not compatible with business interface dependency injection, 
>you have to use JNDI lookup instead.
   