package com.kw.news.Component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "myGroup")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}