
package com.rest.people.services;

import com.rest.people.data.PersonDao;
import com.rest.people.domain.Person;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/people")
public class PersonServiceRS {

    @Inject
    private PersonDao personDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople(){
        
        List<Person> people = personDao.getAllPeople();
        
        System.out.println("People found: " + people);
        
        return people;
        
    }
    
    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id){
        
        Person person = personDao.getPerson(new Person(id));
        
        System.out.println("Person found: " + person);
        
        return person;
        
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Person createPerson(Person person){
        
        personDao.createPerson(person);
        
        System.out.println("Created person: " + person);
        
        return person;
        
    }
    
    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") int id, Person modifiedPerson){
        
        Person person = personDao.getPerson(new Person(id));
        
        if( person != null ){
            
            personDao.updatePerson(modifiedPerson);
            
            System.out.println("Person updated: " + person);

            return Response.ok().entity(modifiedPerson).build();
            
        }else{
            
            return Response.status(Status.NOT_FOUND).build();
            
        }
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id){
    
        Person person = personDao.getPerson(new Person(id));
        
        if( person != null ){
            
            personDao.deletePerson(person);
            
            System.out.println("Person deleted - Id -> " + id);
            
            return Response.ok().build();
            
        }else{
            
            return Response.status(Status.NOT_FOUND).build();
            
        }
    
    }
    
}
