# Java Microservice API #
A simple Java project which uses [Spring Boot](https://projects.spring.io/spring-boot/) together with an embedded [Jetty](https://eclipse.org/jetty/) servlet container to host a simple microservice. It also demonstrates an XML-free Spring configuration; how Spring annotations can be used to map Java exceptions to HTTP status codes; and how Spring gracefully handles the deserialization of Java objects into JSON, including nested and `null` object references.  

***

## Getting Started 
The instructions below detail the pre-requisite technologies; together with installation, deployment and validation steps for a simple Java-based microservice.

### Prerequisites
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Gradle](https://gradle.org/getting-started-gradle-java/#toggle-id-1)

### Installing
Clone this repository, then run the following command from the repository root directory...

    gradle clean build

The `clean` target is optional.

Once this has completed successfully, the built artifact will be found in `build/libs/java-microservice-api.war`, relative to the repository root directory.

## Deployment
The code can be run by either using the `java` command directly...

    java -jar build/libs/java-microservice-api.war 

...or by using `gradle`...

    gradle clean buildRun

Again, the `clean` target is optional, and the `buildRun` target will, as the name suggests, build the code should this have not already been done, prior to running.

Either way, the final couple of lines of the eventual output should be similar to the following...

    2017-01-10 17:40:28.206  INFO 14021 --- [           main] .s.b.c.e.j.JettyEmbeddedServletContainer : Jetty started on port(s) 8080 (http/1.1)
    2017-01-10 17:40:28.209  INFO 14021 --- [           main] io.nextmetaphor.application.Application  : Started Application in 2.457 seconds (JVM running for 2.798)

## Validation ##
To verify the api has been successfully deployed, use `curl` to perform an HTTP `GET` on the appropriate URL...

    $ curl -i http://localhost:8080/person/200
    HTTP/1.1 200 OK
    Date: Tue, 10 Jan 2017 18:09:47 GMT
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    
    {"id":200,"name":"person-name","age":37,"homeAddressModel":{"houseNumber":1,"houseName":"house-name","addressLine1":"home-address-line-1","addressLine2":"home-address-line-2","addressLine3":"home-address-line-3","town":null,"postcode":"postcode","county":"county","country":"country"},"workAddressModel":null}
    
Remove the `-i` flag and pipe the output through `json_pp` if an appropriately intented JSON message is required. 

To verify a simulated HTTP `Internal Server Error` response...

    $ curl -i http://localhost:8080/person/500
    HTTP/1.1 500 Server Error
    Date: Tue, 10 Jan 2017 18:11:30 GMT
    Content-Length: 0

To verify a simulated HTTP `Not Found` response...

    $ curl -i http://localhost:8080/person/404
    HTTP/1.1 404 Not Found
    Date: Tue, 10 Jan 2017 18:11:24 GMT
    Content-Length: 0

Initially refer to [PersonController.java](src/main/java/io/nextmetaphor/controller/PersonController.java) to understand how the requests are processed; also see [ErrorController.java](src/main/java/io/nextmetaphor/controller/ErrorController.java) to understand how exceptions are mapped to HTTP response codes.

## Licence ##
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
