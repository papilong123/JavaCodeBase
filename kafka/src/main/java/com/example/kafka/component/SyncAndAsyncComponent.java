package com.example.kafka.component;

import com.example.kafka.domain.Bar;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SyncAndAsyncComponent {

    @KafkaListener(topics = "async")
    public void listenAsync(Bar bar) {
        System.out.println(bar);
    }

    @KafkaListener(topics = "sync")
    public void listenSync(Bar bar) {
        System.out.println(bar);
    }

}
