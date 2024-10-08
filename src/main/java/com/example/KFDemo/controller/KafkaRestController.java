package com.example.KFDemo.controller;

import com.example.KFDemo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KafkaRestController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/msg")
    public String processMessage(@RequestBody String message) {
        System.out.println( message);
        kafkaProducerService.send(message);
        return "Message sent successfully";
    }

}
