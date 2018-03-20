package com.person.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "age")
    private Integer age;

    @Column(name = "dob")
    private Date dob;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {

        return name;
    }

    public String getLocation() {
        return location;
    }

    public Integer getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }
}
