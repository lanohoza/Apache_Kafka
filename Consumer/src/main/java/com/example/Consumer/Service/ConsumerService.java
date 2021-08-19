package com.example.Consumer.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class ConsumerService {
    @KafkaListener(topics = "nour",groupId = "idgorup")

    public void consume(byte[] message) {
        File f = new File("./Bon_Commande.pdf");
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Consumed message: " +f.getName());
    }
}
