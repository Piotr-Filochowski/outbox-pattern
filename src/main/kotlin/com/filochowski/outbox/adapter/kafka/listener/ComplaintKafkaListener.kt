package com.filochowski.outbox.adapter.kafka.listener

import com.filochowski.outbox.adapter.kafka.publisher.complaint.ComplaintCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ComplaintKafkaListener {

    @KafkaListener(topics = ["complaints"])
    fun complaintTopicMessage(message: ComplaintCreatedEvent) {
        logger.info(message.toString())
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ComplaintKafkaListener::class.java)
    }
}