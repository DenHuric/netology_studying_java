package com.example.hw_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager em;

    public Repository() {

    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }


    @Transactional
    public void generatePersons() {
        Person person1 = Person.builder()
                .name("Test")
                .surename("Testovich")
                .age(23)
                .phoneNumber(89267152312L)
                .cityOfLiving("KZ")
                .build();
        Person person2 = Person.builder()
                .name("Lololo")
                .surename("Lololovich")
                .age(77)
                .phoneNumber(89771234567L)
                .cityOfLiving("KZ")
                .build();
        Person person3 = Person.builder()
                .name("Makhach")
                .surename("Makhachevich")
                .age(11)
                .cityOfLiving("Testovyy")
                .build();
        em.persist(person1);
        em.persist(person2);
        em.persist(person3);
    }


}
