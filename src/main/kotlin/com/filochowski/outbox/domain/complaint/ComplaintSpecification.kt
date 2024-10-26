package com.filochowski.outbox.domain.complaint

import com.filochowski.outbox.ComplaintId
import com.filochowski.outbox.ProductId
import java.time.LocalDateTime

data class Complaint(
    val complaintId: ComplaintId,
    val productId: ProductId,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: Author,
    val text: String
)

data class ComplaintSpecification(
    val productId: ProductId,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: Author,
    val text: String
)

data class Author(val value: String)

