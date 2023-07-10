package com.springtutorial.springcoredemo.config;

import com.springtutorial.springcoredemo.common.Coach;
import com.springtutorial.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //Assign bean id
//    @Bean("aquatic")
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
