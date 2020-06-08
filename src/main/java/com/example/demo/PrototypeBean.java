package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeBean {
    public PrototypeBean() {
        log.info("Prototype instance[" + this.hashCode() + "] created");
    }
}
