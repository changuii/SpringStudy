package dev.changui.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class KafkaMQ implements MessageQueueInterface{
    @Override
    public String readMessage() {
        // code for communnicating with KafkaMQ
        return "message from KafkaMQ";
    }
}
