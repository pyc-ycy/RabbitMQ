//IntelliJ IDEA
//RabbitMQ
//Receiver
//2020/2/15
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "my-queue")
    public void receiverMessage(String message){
        System.out.println("Received: <" + message + ">");
    }
}
