package com.filochowski.outbox.adapter.controller.complaint

import com.filochowski.outbox.domain.complaint.Complaint

data class ComplaintResponseDto(
    val productId: String,
    val createdAt: String,
    val author: String,
    val text: String
) {
    companion object {
        fun fromComplaint(domain: Complaint) = ComplaintResponseDto(
            domain.productId.id.toString(),
            domain.createdAt.toString(),
            domain.author.value,
            domain.text
        )
    }
}