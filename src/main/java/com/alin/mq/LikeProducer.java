package com.alin.mq;

import com.alin.model.Twitter;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Component
public class LikeProducer {
    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final Twitter twitter) {
        jmsMessagingTemplate.convertAndSend(destination, twitter);
    }

}
