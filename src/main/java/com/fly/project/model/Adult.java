package com.fly.project.model;

import lombok.Builder;
import lombok.ToString;


public class Adult extends Person {
    @Builder
    public Adult(FullName fullName ) {
        super(fullName );
    }
}
