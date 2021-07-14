package com.example.kafka.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Slf4j
@AllArgsConstructor
public class DeadLetterQueueService {

    private final KafkaTemplate template;

//    private KafkaOperations kafkaOperations;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<Object, Object> kafkaConsumerFactory,
            KafkaTemplate<Object, Object> template) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory);
        // 创建 FixedBackOff 对象 设置重试间隔 10秒 次数为 3次
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(template), backOff));
        return factory;
    }

    @GetMapping("/send/{input}")
    public void sendFoo(@PathVariable String input) {
        template.send("topic-kl", input);
    }

    @KafkaListener(id = "webGroup", topics = "topic-kl")
    public String listen(String input) {
        log.info("input value: {}", input);
        throw new RuntimeException("dlt");
    }

    @KafkaListener(id = "dltGroup", topics = "topic-kl.DLT")
    public void dltListen(String input) {
        log.info("Received from DLT: " + input);
    }
}
