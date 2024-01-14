package org.muieer.kafka;

import org.muieer.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    CustomProperties customProperties;

    public void sendMessage(String msg) {
        kafkaTemplate.send(customProperties.getTopicName(), msg);
    }
}
