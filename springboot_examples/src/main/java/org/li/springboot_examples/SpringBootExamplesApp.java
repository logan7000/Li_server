package org.li.springboot_examples;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot examples
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.li.springboot_examples.mapper"})
public class SpringBootExamplesApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExamplesApp.class, args);
    }
}