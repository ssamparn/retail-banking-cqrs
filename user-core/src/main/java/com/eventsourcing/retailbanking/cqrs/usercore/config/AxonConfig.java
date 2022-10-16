package com.eventsourcing.retailbanking.cqrs.usercore.config;

import com.mongodb.client.MongoClient;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.serialization.json.JacksonSerializer;
import org.axonframework.spring.config.SpringAxonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    public EmbeddedEventStore eventStore(EventStorageEngine storageEngine,
                                         SpringAxonConfiguration configuration) {
        return EmbeddedEventStore.builder()
                .storageEngine(storageEngine)
                .messageMonitor(configuration.getObject().messageMonitor(EventStore.class, "usereventstore"))
                .build();
    }

    @Bean
    public EventStorageEngine storageEngine(MongoClient mongoClient) {
        return MongoEventStorageEngine.builder()
                .mongoTemplate(DefaultMongoTemplate.builder()
                        .mongoDatabase(mongoClient)
                        .build()
                )
                .eventSerializer(JacksonSerializer.defaultSerializer())
                .snapshotSerializer(JacksonSerializer.defaultSerializer())
                .build();
    }
}
