package com.example.kafka.controller;

import com.example.kafka.entity.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxController {

    @Autowired
    KafkaTemplate<Object, Object> template;

//    @Transactional
    @PostMapping("/sendtx/foo")
    public void sendFoo(Foo foo){
        template.executeInTransaction(kafkaTemplate -> {
            kafkaTemplate.send("foo", "foo");
            if("error".equals(foo)){
                throw new RuntimeException("failed");
            }
            kafkaTemplate.send("foo", "bar");
            return true;
        });
    }
}
