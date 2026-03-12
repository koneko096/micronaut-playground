package micronaut.playground.domain.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "visit")
data class Visit(
    @field:Id
    @GeneratedValue var id: Long? = null,
    val name: String,
    @Column(name = "created_at", columnDefinition = "TIMESTAMP") var createdAt: LocalDateTime
) {
    constructor(name: String): this(null, name, LocalDateTime.now())
}