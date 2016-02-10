# call-handler
CXF JAX-RS service with Bean Validation and Spring + Java 8.

The application consists of a single service ***http://localhost:port/services/callService/addCall*** which accepts a JSON object Call:
```json  
  Example: {
    "firstName": "Ivan",
    "lastName": "Ivanov",
    "telephoneNumber": "+(375)-123456789"
    }
```
Input data validates it with the Bean Validation and stores the result of a temporary directory **(temp/CALL_HANDLER/yyyyMMdd)**, i't may be temporary directory servlet container. Application contains SoapUI and JUnit tests. The application runs on Tomcat version 8 and above as well as on the Jetty version 9.
