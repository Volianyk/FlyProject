package com.fly.project.model;

import lombok.Builder;

public class Infant extends Person {
    private Adult associate;

    @Builder
    public Infant(FullName fullName, int age, Adult associate) {
        super(fullName, age);
        this.associate = associate;
    }
}
