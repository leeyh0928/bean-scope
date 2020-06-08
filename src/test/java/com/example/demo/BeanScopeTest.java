package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class BeanScopeTest {

    @Test
    public void givenPrototypeInjection_WhenLookup_ThenNewInstanceReturn() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PrototypeBean firstInstance = context.getBean(SingletonLookupBean.class).getPrototypeBean();
        PrototypeBean secondInstance = context.getBean(SingletonLookupBean.class).getPrototypeBean();

        assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Test
    public void givenPrototypeInjection_WhenProvider_ThenNewInstanceReturn() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PrototypeBean firstInstance = context.getBean(SingletonProviderBean.class).getPrototypeInstance();
        PrototypeBean secondInstance = context.getBean(SingletonProviderBean.class).getPrototypeInstance();

        assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Test
    public void givenPrototypeInjection_WhenFunction_ThenNewInstanceReturn() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PrototypeFunctionBean firstInstance = context.getBean(SingletonFunctionBean.class).getPrototypeInstance("first");
        PrototypeFunctionBean secondInstance = context.getBean(SingletonFunctionBean.class).getPrototypeInstance("second");

        assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Test
    public void givenPrototypeInjection_WhenObjectFactory_ThenNewInstanceReturn() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PrototypeBean firstInstance = context.getBean(SingletonObjectFactoryBean.class).getPrototypeInstance();
        PrototypeBean secondInstance = context.getBean(SingletonObjectFactoryBean.class).getPrototypeInstance();

        assertTrue("New instance expected", firstInstance != secondInstance);
    }
}
