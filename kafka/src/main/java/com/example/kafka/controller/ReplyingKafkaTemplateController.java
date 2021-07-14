package com.example.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReplyingKafkaTemplateController {

//    @Bean
//    public ConcurrentMessageListenerContainer<String, String> repliesContainer(ConcurrentKafkaListenerContainerFactory<String, String> containerFactory){
//        ConcurrentMessageListenerContainer<String, String> repliesContainer = containerFactory.createContainer("replies");
//        repliesContainer.getContainerProperties().setGroupId("repliesGroup");
//        repliesContainer.setAutoStartup(false);
//        return repliesContainer;
//    }

//    @Bean
//    public ReplyingKafkaTemplate<String, String, String> replyingTemplate(ProducerFactory<String, String> pf, ConcurrentMessageListenerContainer<String, String> repliesContainer) {
//        return new ReplyingKafkaTemplate(pf, repliesContainer);
//    }

////    @Bean
////    public KafkaTemplate kafkaTemplate(ProducerFactory<String, String> pf) {
////        return new KafkaTemplate(pf);
////    }

//    @Autowired
//    private ReplyingKafkaTemplate template;

//    /**
//     * 事务支持
//     * @param input
//     * @throws Exception
//     */
//    @GetMapping("/reply/{input}")
//    @Transactional(rollbackFor = RuntimeException.class)
//    public void sendFoo(@PathVariable String input) throws Exception {
//        ProducerRecord<String, String> record = new ProducerRecord<>("topic-kl", input);
//        RequestReplyFuture<String, String, String> replyFuture = template.sendAndReceive(record);
//        ConsumerRecord<String, String> consumerRecord = replyFuture.get();
//        System.err.println("Return value: " + consumerRecord.value());
//    }

//    @KafkaListener(id = "webGroup", topics = "topic-kl")
//    @SendTo("topic_input")
//    public String listen(String input) {
//        log.info("input value: {}", input);
//        return "successful";
//    }

}
