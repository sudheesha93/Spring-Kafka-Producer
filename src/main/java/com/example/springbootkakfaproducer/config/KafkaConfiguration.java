package com.example.springbootkakfaproducer.config;

import com.example.springbootkakfaproducer.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ProducerFactory producerFactory(){
         Map<String, Object> config = new HashMap<>();
         // server name should be mentioned
         config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
         config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

         // Kafta output data format need to be serialized here
         config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
         return new DefaultKafkaProducerFactory(config);
    }

    // Kafta template use the configurations mentioned in the producerFactory
    @Bean
    public KafkaTemplate<String, User> kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());
    }
}


