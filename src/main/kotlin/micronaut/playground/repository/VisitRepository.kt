package micronaut.playground.repository

import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import micronaut.playground.domain.entity.Visit
import reactor.core.publisher.Mono

@R2dbcRepository(dialect = Dialect.H2)
interface VisitRepository: ReactiveStreamsCrudRepository<Visit, Long> {
    @Query("SELECT COUNT(*) FROM Visit v WHERE v.name = :name")
    fun countVisit(@NotEmpty name: String): Mono<Long>

    @Query("SELECT * FROM Visit v WHERE v.name = :name ORDER BY v.created_at DESC")
    fun lastVisit(@NotEmpty name: String): Mono<Visit>

    @Query("INSERT INTO Visit(name, created_at) VALUES (:name, :createdAt)")
    fun addVisit(@NotNull visit: Visit): Mono<Void>
}
