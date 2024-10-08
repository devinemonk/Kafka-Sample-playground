package com.example.KFDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Value("${kafka.topic}")
    private String topic;

    private int partition = 0;
    private String key = "MyKey";
    private final KafkaTemplate kafkaTemplate;

    KafkaProducerService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate  = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(topic ,   partition , key , message);
        log.info("send message : \" "+ message + "\" to " + topic + "partition " + partition );
    }
}
