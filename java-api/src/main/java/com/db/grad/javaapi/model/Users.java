package com.db.grad.javaapi.model;


import com.db.grad.javaapi.utils.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String role;


    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @JoinTable(
            name = "book_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> ownedBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public void setOwnedBooks(Set<Book> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }

}
