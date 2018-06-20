package com.example.ssn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private List<User> users;
    private String name;
    private Long id;

    public Group(List<User> users, String name, Long id) {
        this.users = users;
        this.name = name;
        this.id = id;
    }

    public Group(List<User> users, String name) {
        this.users = users;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(users, group.users) &&
                Objects.equals(name, group.name) &&
                Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(users, name, id);
    }
}
