package com.filochowski.outbox.adapter.controller.complaint

import com.filochowski.outbox.ProductId
import com.filochowski.outbox.domain.complaint.Author
import com.filochowski.outbox.domain.complaint.Complaint
import java.util.*

data class ComplaintRequestDto(
    val productId: String,
    val author: String,
    val text: String
) {
    fun toComplaint() = Complaint(
        productId = ProductId(UUID.fromString(this.productId)),
        author = Author(this.author),
        text = this.text
    )
}