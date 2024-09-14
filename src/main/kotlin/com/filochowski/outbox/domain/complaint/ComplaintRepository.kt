package com.filochowski.outbox.domain.complaint

interface ComplaintRepository {

    fun addNew(complaint: Complaint)

    fun getAll(): Set<Complaint>
}