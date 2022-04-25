
package com.rest.people.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest-service")
public class JAXRSActivator extends Application{
    
    // Access URL -> GET ----->     localhost:8080/10-people-rest-service/rest-service/people/
    //                              localhost:8080/10-people-rest-service/rest-service/people/{id}
    //               POST ----->    localhost:8080/10-people-rest-service/rest-service/people/
    //               PUT ----->     localhost:8080/10-people-rest-service/rest-service/people/{id}
    //               DELETE ----->  localhost:8080/10-people-rest-service/rest-service/people/{id} 
    
}