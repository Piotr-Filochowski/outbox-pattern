package com.filochowski.outbox.adapter.kafka.publisher.complaint

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaComplaintEventsPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${kafka.topics.complaints.name}") private val complaintCreatedTopicName: String,
    private val objectMapper: ObjectMapper
) {

    fun publish(event: ComplaintCreatedEvent) {
        kafkaTemplate.send(complaintCreatedTopicName, objectMapper.writeValueAsString(event))
    }
}


data class ComplaintCreatedEvent(
    val id: String
)