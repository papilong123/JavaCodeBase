package com.example.kafka.component;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaEmbededTest.class)
@EmbeddedKafka(count = 3, ports = {9092, 9093, 9094}, controlledShutdown = true)
public class KafkaEmbededTest {

    @Test
    public void contextLoads() throws IOException{
        System.in.read();
    }
}
