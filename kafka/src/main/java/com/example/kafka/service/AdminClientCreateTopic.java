package com.example.kafka.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 代码中通过AdminClient创建Topic，项目一启动就创建，创建了AdminClient的bean实例
 */
@Service
public class AdminClientCreateTopic {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public void testCreateTopic(){
        AdminClient client = AdminClient.create(properties.buildAdminProperties());
        if(client!=null){
            try {
                Collection<NewTopic> newTopics = new ArrayList<>(1);
                newTopics.add(new NewTopic("topic-k2", 1, (short) 1));
                client.createTopics(newTopics);
            }catch (Throwable e){
                e.printStackTrace();
            }finally {
                client.close();
            }
        }
    }

}
