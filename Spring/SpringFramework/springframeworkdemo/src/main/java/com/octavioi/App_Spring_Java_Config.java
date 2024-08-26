package com.octavioi;

import com.octavioi.parts.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.octavioi.config.AppConfig;
import com.octavioi.config.AppConfig2;

public class App_Spring_Java_Config {
    public static void main(String[] args) {
        //javaConfig();
        annotationConfig();

        

    }

    public static void javaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Coder2 coder = context.getBean("coder2", Coder2.class);
            coder.code();
        }
    }

    public static void annotationConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Coder2 coder = context.getBean(Coder2.class);
            coder.code();
        }
    }
}