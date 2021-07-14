package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * 配置中创建topic，项目一启动就创建NewTopic主题实例，还创建一个KafkaAdmin的bean实例
 */
@Configuration
public class KafkaConfig {

    @Bean
    public KafkaAdmin kafkaAdmin(KafkaProperties properties){
        KafkaAdmin admin = new KafkaAdmin(properties.buildAdminProperties());
        admin.setFatalIfBrokerNotAvailable(true);
        admin.setAutoCreate(true);
        return admin;
    }

    @Bean
    public NewTopic topic2(){
        return new NewTopic("topic-k3", 1, (short) 1);
    }
}
