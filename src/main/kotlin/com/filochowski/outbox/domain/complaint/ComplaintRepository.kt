package com.filochowski.outbox.domain.complaint

interface ComplaintRepository {

    fun addNew(complaintSpecification: ComplaintSpecification)

    fun getAll(): Set<Complaint>
}