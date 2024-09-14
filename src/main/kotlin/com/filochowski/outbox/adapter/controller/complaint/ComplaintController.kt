package com.filochowski.outbox.adapter.controller.complaint

import com.filochowski.outbox.domain.complaint.ComplaintService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/complaints")
class ComplaintController(
    private val service: ComplaintService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody request: ComplaintRequestDto) {
        service.createComplaint(request.toComplaint())
    }

    @GetMapping
    fun getAll() = service.getAll().map { ComplaintResponseDto.fromComplaint(it) }
}