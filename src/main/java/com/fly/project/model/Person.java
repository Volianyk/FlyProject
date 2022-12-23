package com.fly.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private FullName fullName;
    // private String email;
    // private int age;

    @ToString
    @Getter
    @AllArgsConstructor
    public static class FullName {
        private String firstName;
        private String lastName;
    }
}
