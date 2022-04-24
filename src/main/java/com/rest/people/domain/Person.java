
package com.rest.people.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Person.getAllPeople", 
                query = "SELECT p FROM Person p ORDER BY p.personId")
})
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String Surname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private int phone;
    
    public Person(){
        
    }
    
    public Person(int personId){
        
        this.personId = personId;
        
    }
    
    public Person(String name, String Surname, String email, int phone) {
        this.name = name;
        this.Surname = Surname;
        this.email = email;
        this.phone = phone;
    }
    
    public Person(int personId, String name, String Surname, String email, int phone) {
        this.personId = personId;
        this.name = name;
        this.Surname = Surname;
        this.email = email;
        this.phone = phone;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", name=" + name + ", Surname=" + Surname + ", email=" + email + ", phone=" + phone + '}';
    }
    
}