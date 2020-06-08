package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeFunctionBean {
    private String name;

    public PrototypeFunctionBean(String name) {
        this.name = name;
        log.info("Prototype instance[" + this.hashCode()+ "] " + name + " created");
    }
}
