package com.example.Producer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    private KafkaTemplate<Object, byte[]> kafkaTemplate;

    private static final String topic="nour";

    @PostMapping(value = "/publish")
    public void post(@RequestParam String message) throws IOException {
        File file = new File(message);
        byte[] fileb = Files.readAllBytes(file.toPath());
        kafkaTemplate.send(topic,fileb);
        System.out.println("published successfully");
    }
}
