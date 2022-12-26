package com.fly.project.model;

import lombok.Builder;

public class Adult extends Person {
    @Builder
    public Adult(FullName fullName, int age) {
        super(fullName, age);
    }
}
