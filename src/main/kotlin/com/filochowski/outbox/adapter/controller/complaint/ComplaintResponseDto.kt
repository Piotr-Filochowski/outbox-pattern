package com.filochowski.outbox.adapter.controller.complaint

import com.filochowski.outbox.domain.complaint.Complaint
import com.filochowski.outbox.domain.complaint.ComplaintSpecification

data class ComplaintResponseDto(
    val id: String,
    val productId: String,
    val createdAt: String,
    val author: String,
    val text: String
) {
    companion object {
        fun fromComplaint(domain: Complaint) = ComplaintResponseDto(
            domain.complaintId.raw.toString(),
            domain.productId.raw.toString(),
            domain.createdAt.toString(),
            domain.author.value,
            domain.text
        )
    }
}