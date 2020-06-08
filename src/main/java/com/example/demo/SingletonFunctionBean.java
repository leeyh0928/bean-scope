package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SingletonFunctionBean {
    @Autowired
    private Function<String, PrototypeFunctionBean> beanFactory;

    public PrototypeFunctionBean getPrototypeInstance(String name) {
        return beanFactory.apply(name);
    }
}
