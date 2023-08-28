package org.example.project3.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*@Component*/
public class PersonDAO {

    /*private final SessionFactory sessionFactory;

@Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@Transactional(readOnly = true)
    public List<Person> index(){
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Person",Person.class).getResultList();
}

@Transactional(readOnly = true)
    public Optional<Person> show(String name){

    Session session = sessionFactory.getCurrentSession();
    String query = "from Person p where p.name = '"+name+"'";
    return session.createQuery(query,Person.class).getResultList().stream().findAny();
    }

    @Transactional(readOnly = true)
    public Person show(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class,id);
    }
    @Transactional
    public void save(Person person){
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }
@Transactional
    public void update(int id,Person updatedPerson){
        Session session = sessionFactory.getCurrentSession();
        Person personToBeUpdated = session.get(Person.class,id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setBooks(updatedPerson.getBooks());
    }
@Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class,id));
    }
@Transactional(readOnly = true)
    public List<Book> getBooksByPersonId(int id){

    Session session = sessionFactory.getCurrentSession();
    Person person = session.get(Person.class,id);

    List<Book> list = person.getBooks();
    *//*for(Book book : list)
        Hibernate.initialize(book);*//*

    return list;
    }*/
}
