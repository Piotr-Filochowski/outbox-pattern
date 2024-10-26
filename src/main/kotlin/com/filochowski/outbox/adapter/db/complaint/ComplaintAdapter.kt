package com.filochowski.outbox.adapter.db.complaint

import com.filochowski.outbox.ComplaintId
import com.filochowski.outbox.ProductId
import com.filochowski.outbox.adapter.db.complaint.ComplaintTable.author
import com.filochowski.outbox.adapter.db.complaint.ComplaintTable.complaintId
import com.filochowski.outbox.adapter.db.complaint.ComplaintTable.createdAt
import com.filochowski.outbox.adapter.db.complaint.ComplaintTable.productId
import com.filochowski.outbox.adapter.db.complaint.ComplaintTable.text
import com.filochowski.outbox.domain.complaint.Author
import com.filochowski.outbox.domain.complaint.Complaint
import com.filochowski.outbox.domain.complaint.ComplaintSpecification
import com.filochowski.outbox.domain.complaint.ComplaintRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Component

@Component
class ComplaintAdapter: ComplaintRepository {

    override fun addNew(complaintSpecification: ComplaintSpecification) {
        ComplaintTable.insert { table ->
            table[productId] = complaintSpecification.productId.raw
            table[createdAt] = complaintSpecification.createdAt
            table[author] = complaintSpecification.author.value
            table[text] = complaintSpecification.text
        }
    }

    override fun getAll(): Set<Complaint> = ComplaintTable.selectAll().map { it.toDomain() }.toSet()
}

private fun ResultRow.toDomain() =
    Complaint(
        ComplaintId(this[complaintId]),
        ProductId(this[productId]),
        this[createdAt],
        Author(this[author]),
        this[text]
    )
