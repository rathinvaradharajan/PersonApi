package com.person.Model;

import javax.persistence.Id;

public class PersonModel {
    @Id
    private String name;

    private Integer age;

    private String location;

    private String dob;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDob(String dob) {
        String s[] = dob.split(" ");
        this.dob = s[0];
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getDob() {
        return dob;
    }
}
