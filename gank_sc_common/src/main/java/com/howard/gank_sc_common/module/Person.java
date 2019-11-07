package com.howard.gank_sc_common.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
    private String company;
    private String job;
    private String comment;

    public Person() {
    }

    public Person(String id, String name, int age, String company, String job, String comment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.company = company;
        this.job = job;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
