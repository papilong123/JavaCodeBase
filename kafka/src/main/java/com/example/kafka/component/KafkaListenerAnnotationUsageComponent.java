package com.example.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerAnnotationUsageComponent {

//    https://blog.csdn.net/yuanlong122716/article/details/105160545
//    https://shirenchuang.blog.csdn.net/article/details/109803987
//    https://www.jianshu.com/c/0c9d83802b0c
//    https://blog.csdn.net/Black1499/article/details/90474929
    @KafkaListener(id = "testId", topics = {"topic_input"}, idIsGroup = false, groupId = "testGroupId",
            clientIdPrefix = "myClientId", concurrency = "${listen.concurrency:2}", errorHandler = "kafkaDefaultListenerErrorHandler",
            properties = {"enable.auto.commit:false", "max.poll.interval.ms:6000"})
    public void listen1(ConsumerRecord<?, ?> record){
        System.out.println(record);
    }

//    监听topic1的0,1分区；监听topic2的第0分区,并且第1分区从offset为100的开始消费
//    @KafkaListener(id = "testId2", concurrency = "#{listen.concurrency:1}", topicPartitions = {
//            @TopicPartition(topic = "topic_k1", partitions = {"0", "1"}),
//            @TopicPartition(topic = "topic_k2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "3"))
//    })
//    public void listen2(String data){
//        System.out.println(data);
//    }
}
