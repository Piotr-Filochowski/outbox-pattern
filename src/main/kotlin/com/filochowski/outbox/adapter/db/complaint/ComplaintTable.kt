package com.filochowski.outbox.adapter.db.complaint

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object ComplaintTable: Table("complaints") {
    val productId = uuid("product_id")
    val createdAt = datetime("created_at")
    val author = varchar("author", 250)
    val text = varchar("text", 10_000)

    override val primaryKey = PrimaryKey(productId, author)
}