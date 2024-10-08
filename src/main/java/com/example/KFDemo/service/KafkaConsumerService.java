package com.example.KFDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "#{'${kafka.topic}'}", groupId = "spring-boot")
    public void processMessage(String message  , @Header(KafkaHeaders.RECEIVED_KEY) String key,
                               @Header(KafkaHeaders.RECEIVED_PARTITION) List partitionsIds,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
                               @Header(KafkaHeaders.OFFSET) List offsets
    ) {
        log.info("---Received message: " + message + " with key: " + key);
        log.info("---From partition: " + partitionsIds + " from topic: " + topics + " with offset: " + offsets);
    }

}
