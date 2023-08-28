package org.example.project3.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*@Component*/
public class BookDAO {
    /*private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional(readOnly = true)
    public List<Book> index(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book",Book.class).getResultList();
    }
    @Transactional(readOnly = true)
    public Book show(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class,id);
    }
    @Transactional
    public void save(Book book){
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }
    @Transactional
    public void update(int id,Book updatedBook){
        Session session = sessionFactory.getCurrentSession();
        Book bookToBeUpdated = session.get(Book.class,id);
        bookToBeUpdated.setName(updatedBook.getName());
        bookToBeUpdated.setAuthor(updatedBook.getAuthor());
        bookToBeUpdated.setOwner(updatedBook.getOwner());
        bookToBeUpdated.setYear(updatedBook.getYear());
    }
    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Book.class,id));
    }
    @Transactional
    public void assign(int personId,int bookId){
        Session session = sessionFactory.getCurrentSession();

        Book assignedBook = session.get(Book.class,bookId);
        Person person = session.get(Person.class,personId);

        assignedBook.setOwner(person);
        person.getBooks().add(assignedBook);
    }
    @Transactional
    public void release(int bookId){
        Session session = sessionFactory.getCurrentSession();
        Book releasedBook = session.get(Book.class,bookId);

        Person personToRelease = releasedBook.getOwner();
        personToRelease.getBooks().remove(releasedBook);

        releasedBook.setOwner(null);
    }
    @Transactional(readOnly = true)
    public Optional<Person> getBookOwner(int bookId){
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class,bookId);
        Person owner = book.getOwner();
        Optional<Person> opt = Optional.ofNullable(owner);
        return opt;
    }*/


}
