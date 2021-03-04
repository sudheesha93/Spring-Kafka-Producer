package com.example.springbootkakfaproducer.resourse;

import com.example.springbootkakfaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {

    // By default kafka serializes the data to string
    // if we need to post any object configurations are mandatory
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC="KAFKA_PRODUCER_TOPIC";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") String name){
        //kafkaTemplate.send(TOPIC, name);
        kafkaTemplate.send(TOPIC, new User(name,"Walmart",26,(long)20000));
        return "Published succeessfully";

    }
}
