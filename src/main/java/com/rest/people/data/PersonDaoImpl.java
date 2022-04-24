
package com.rest.people.data;

import com.rest.people.domain.Person;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonDaoImpl implements PersonDao{

    @PersistenceContext(unitName = "PeoplePU")
    EntityManager em;
    
    @Override
    public List<Person> getAllPeople() {
        
        return em.createNamedQuery("Person.getAllPeople").getResultList();
        
    }

    @Override
    public Person getPerson(Person person) {
        
        return em.find(Person.class, person.getPersonId());
        
    }

    @Override
    public void createPerson(Person person) {

        em.persist(person);
        em.flush();
        
    }

    @Override
    public void updatePerson(Person person) {
        
        em.merge(person);
        
    }

    @Override
    public void deletePerson(Person person) {

        em.remove(em.merge(person));

    }
    
}
