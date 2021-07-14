package com.example.kafka.service;

import com.example.kafka.domain.Bar;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class SyncAndAsyncService {

    @Autowired
    private final KafkaTemplate<Object, Object> template;

//    异步
    public void sendAsync(final Bar bar){

//        发送类对象
        ListenableFuture<SendResult<Object, Object>> future = template.send("ansyc",bar);
        future.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            @Override
            public void onSuccess(SendResult<Object, Object> sendResult) {
                System.out.println("发送消息成功：" + sendResult);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败："+ throwable.getMessage());
            }
        });
    }

//    另一种异步方式，addCallBack()添加两个lambda表达式
    public void sendMessage2(String callbackMessage) {
        template.send("topic1", callbackMessage).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());
        });
    }


//    同步
    public void sendSync(final Bar bar) {
//        发送ProducerRecord
        ProducerRecord<Object, Object> producerRecord = new ProducerRecord<>("sync", bar);
        ListenableFuture<SendResult<Object,Object>> futureRaw = template.send("topic-kl","kl");
        ListenableFuture<SendResult<Object,Object>> future = template.send(producerRecord);
        try {
            SendResult<Object,Object> result = future.get(10, TimeUnit.SECONDS);
            System.out.println("发送成功");
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
