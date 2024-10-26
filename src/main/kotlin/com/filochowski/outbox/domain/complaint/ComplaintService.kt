package com.filochowski.outbox.domain.complaint

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ComplaintService(
    private val repo: ComplaintRepository
) {

    @Transactional
    fun createComplaint(complaintSpecification: ComplaintSpecification) {
        repo.addNew(complaintSpecification)
    }

    @Transactional(readOnly = true)
    fun getAll() = repo.getAll()
}