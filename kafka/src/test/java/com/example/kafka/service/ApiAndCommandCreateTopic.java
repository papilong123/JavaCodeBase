package com.example.kafka.service;

import kafka.admin.TopicCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 其他方式创建Topic
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiAndCommandCreateTopic.class)
public class ApiAndCommandCreateTopic {

//    api方式创建
//    @Test
//    public void testCreateTopicAdminUtil()throws Exception{
//        ZkClient zkClient =new ZkClient("127.0.0.1:2181", 3000, 3000, ZKStringSerializer$.MODULE$)
//        String topicName = "topic-kl";
//        int partitions = 1;
//        int replication = 1;
//        AdminUtils.createTopic(zkClient,topicName,partitions,replication,new Properties());
//    }

    @Test
    public void testCreateTopicCommand(){
        String [] options= new String[]{
                "--create",
                "--zookeeper","192.168.3.15:2181",
                "--partitions", "1",
                "--replication-factor", "1",
                "--topic", "topic-kl"
        };
        TopicCommand.main(options);
    }
}
