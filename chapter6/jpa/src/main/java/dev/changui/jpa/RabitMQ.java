package dev.changui.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class RabitMQ implements MessageQueueInterface{
    @Override
    public String readMessage() {
        // code for communnicating with RabbitMQ
        return "message from rabbitmq";
    }
}
