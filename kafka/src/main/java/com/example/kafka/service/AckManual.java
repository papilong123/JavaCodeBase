package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public class AckManual {

    @KafkaListener(id = "webGroup", topics = "topic-kl")
    public String listen(String input, Acknowledgment ack) {
        System.out.println(input);
        if ("kl".equals(input)) {
            ack.acknowledge();
        }
        return "successful";
    }
}
