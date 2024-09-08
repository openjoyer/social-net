package org.tylerpants.postservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic notificationTopic() {
        return new NewTopic("notification", 1, (short) 1);
    }
}
