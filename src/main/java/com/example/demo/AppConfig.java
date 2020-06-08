package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.function.Function;

@Slf4j
@ComponentScan("com.example.demo")
@Configuration
public class AppConfig {

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public Function<String, PrototypeFunctionBean> beanFactory() {
        return this::prototypeBeanWithParam;
    }

    @Bean
    @Scope(value = "prototype")
    public PrototypeFunctionBean prototypeBeanWithParam(String name) {
        return new PrototypeFunctionBean(name);
    }
}
