package com.pyc.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RabbitmqApplication implements CommandLineRunner {

    // using rabbit template
    @Autowired
    RabbitTemplate template;

    // define destination also called queue, named my-queue
    @Bean
    public Queue pycQueue(){
        return new Queue("my-queue");
    }

    @Override
    public void run(String... args) throws Exception {
        // using convertAndSend method to send message
        template.convertAndSend("my-queue", "A greet message come from RabbitMQ");
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
