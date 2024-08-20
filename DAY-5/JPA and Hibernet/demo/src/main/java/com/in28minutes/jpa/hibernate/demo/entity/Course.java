package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "CourseDetails") not working 
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    protected Course(){

    }

    public Course(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
