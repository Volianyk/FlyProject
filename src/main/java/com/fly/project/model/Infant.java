package com.fly.project.model;

import lombok.Builder;


public class Infant extends Person{
    private Adult associate;
    public Infant(FullName fullName, int age) {
        super(fullName, age);
    }
}
