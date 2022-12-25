package com.fly.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Person {
    private FullName fullName;
    //  private String email;
    // private int age;


    @Getter
    @AllArgsConstructor
    public static class FullName {
        private String firstName;
        private String lastName;

        @Override
        public String toString() {
            return " " + firstName + " " + lastName;
        }
    }

    @Override
    public String toString() {
        return "Name" + fullName;
        //   "email: " + email + '\n' +
        //  "age: " + age;
    }
}
