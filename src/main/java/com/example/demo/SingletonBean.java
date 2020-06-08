package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@Component
public class SingletonBean {
    @Autowired
    private  PrototypeBean prototypeBean;

    public SingletonBean() {
        log.info("SingletonBean instance[" + this.hashCode() + "] created");
    }

    public PrototypeBean getPrototypeBean() {
        log.info(String.valueOf(LocalTime.now()));
        return prototypeBean;
    }
}
