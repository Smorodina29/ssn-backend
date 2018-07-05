package com.example.ssn.contracts;

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
    private List<UserDto> userDtos;
    private String name;
    private Long id;

    public Group(List<UserDto> userDtos, String name, Long id) {
        this.userDtos = userDtos;
        this.name = name;
        this.id = id;
    }

    public Group(List<UserDto> userDtos, String name) {
        this.userDtos = userDtos;
        this.name = name;
    }

    public Group(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
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
        return Objects.equals(userDtos, group.userDtos) &&
                Objects.equals(name, group.name) &&
                Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userDtos, name, id);
    }
}
