package com.design.hice.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/15 11:38 AM
 **/
public class MyInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("MyInitializer");
    }
}
