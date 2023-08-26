package org.example.project3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name should not be empty.")
    @Size(min=2,max = 30, message="Name supposed to be between 2 and 30 symbols.")
    @Column(name = "name")
    private String name;
    @Min(value = 0,message = "Age supposed to be positive value.")
    @Column(name = "age")
    private int age;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Book> books;

    public Person(){}

    public Person( String name, int age) {
        this.name = name;
        this.age = age;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }*/
}
