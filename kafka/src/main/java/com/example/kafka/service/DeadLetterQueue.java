package com.example.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Slf4j
public class DeadLetterQueue {

//    @Autowired
//    private KafkaTemplate template;
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object, Object> kafkaConsumerFactory,
//            KafkaTemplate<Object, Object> template) {
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        configurer.configure(factory, kafkaConsumerFactory);
//        //最大重试三次
//        factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(template), 3));
//        return factory;
//    }
//
//    @GetMapping("/send/{input}")
//    public void sendFoo(@PathVariable String input) {
//        template.send("topic-kl", input);
//    }
//
//    @KafkaListener(id = "webGroup", topics = "topic-kl")
//    public String listen(String input) {
//        log.info("input value: {}", input);
//        throw new RuntimeException("dlt");
//    }
//
//    @KafkaListener(id = "dltGroup", topics = "topic-kl.DLT")
//    public void dltListen(String input) {
//        log.info("Received from DLT: " + input);
//    }
}
