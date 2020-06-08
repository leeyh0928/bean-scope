package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;


public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstPrototype.equals(secondPrototype));

        // Lookup
        PrototypeBean firstPrototypeLookup = context.getBean(SingletonLookupBean.class).getPrototypeBean();
        PrototypeBean secondPrototypeLookup = context.getBean(SingletonLookupBean.class).getPrototypeBean();
        Assert.isTrue(!firstPrototypeLookup.equals(secondPrototypeLookup));

        // Provider
        PrototypeBean firstPrototypeProvider = context.getBean(SingletonProviderBean.class).getPrototypeInstance();
        PrototypeBean secondPrototypeProvider = context.getBean(SingletonProviderBean.class).getPrototypeInstance();
        Assert.isTrue(!firstPrototypeProvider.equals(secondPrototypeProvider));

        // Bean Factory
        PrototypeBean firstPrototypeFactory = context.getBean(SingletonObjectFactoryBean.class).getPrototypeInstance();
        PrototypeBean secondPrototypeFactory = context.getBean(SingletonObjectFactoryBean.class).getPrototypeInstance();
        Assert.isTrue(!firstPrototypeFactory.equals(secondPrototypeFactory));

        // function bean
        PrototypeFunctionBean firstPrototypeFunctionBean = context.getBean(SingletonFunctionBean.class).getPrototypeInstance("firstFunctionBean");
        PrototypeFunctionBean secondPrototypeFunctionBean = context.getBean(SingletonFunctionBean.class).getPrototypeInstance("secondFunctionBean");
        Assert.isTrue(!firstPrototypeFunctionBean.equals(secondPrototypeFunctionBean));

    }

}
