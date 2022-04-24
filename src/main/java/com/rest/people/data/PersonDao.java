
package com.rest.people.data;

import com.rest.people.domain.Person;

import java.util.List;

public interface PersonDao {
 
    public List<Person> getAllPeople();
    
    public Person getPerson(Person person);
    
    public void createPerson(Person person);
    
    public void updatePerson(Person person);
    
    public void deletePerson(Person person);
    
}
