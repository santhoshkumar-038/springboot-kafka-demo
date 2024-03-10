package com.santhosh.controller;

import com.santhosh.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8080/api/v1/kafka/publisher?message=hello world
    @GetMapping("/publisher")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
         kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message is sent to the Topic");
    }
}
