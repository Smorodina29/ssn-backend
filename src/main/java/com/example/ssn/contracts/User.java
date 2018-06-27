package com.example.ssn.contracts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private Roles role;
    private boolean deleted;
    private Group[] groups;
    private String username;
    private String password;
    private String position;

    public User() {
    }


    public User(String firstname, String lastname, Roles role, String username, String password, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public User(long id, String firstname, String lastname, Roles role, String username, String password, String position) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return deleted == user.deleted &&
                Objects.equals(id, user.id) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(role, user.role) &&
                Arrays.equals(groups, user.groups) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, firstname, lastname, role, deleted, username, password, position);
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }
}
