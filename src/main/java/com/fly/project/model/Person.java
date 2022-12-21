package com.fly.project.model;

public class Person {
private FullName fullName;
private String email;
private int age;
    class FullName{
        private String firstName;
        private String lastName;
    }

    public Person(FullName fullName, String email, int age) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
    }
}
