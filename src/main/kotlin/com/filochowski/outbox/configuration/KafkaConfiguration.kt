package com.filochowski.outbox.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.converter.JsonMessageConverter

@Configuration
class KafkaConfiguration {

    @Bean
    fun kafkaTemplate(
        producerFactory: ProducerFactory<String, String>,
        consumerFactory: ConsumerFactory<String, String>
    ) =
        KafkaTemplate(producerFactory).apply {
            setObservationEnabled(true)
            setConsumerFactory(consumerFactory)
        }

    @Bean
    fun kafkaListenerContainerFactory(consumerFactory: ConsumerFactory<String, String>) =
        ConcurrentKafkaListenerContainerFactory<String, String>()
            .apply {
                this.containerProperties.isObservationEnabled = true
                this.consumerFactory = consumerFactory
                this.setRecordMessageConverter(JsonMessageConverter())
            }
}