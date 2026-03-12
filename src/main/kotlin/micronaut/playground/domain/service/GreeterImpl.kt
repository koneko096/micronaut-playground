package micronaut.playground.domain.service

import io.micronaut.context.annotation.Property
import micronaut.playground.client.model.Hello
import micronaut.playground.repository.VisitRepository
import jakarta.inject.Singleton
import micronaut.playground.domain.entity.Visit
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Singleton
open class GreeterImpl(val visitRepository: VisitRepository) : Greeter {

    @field:Property(name = "template.prefix")
    var prefix: String? = null

    override fun greetHello(name: String): Mono<Hello> {
        val lastVisitSingle = visitRepository.lastVisit(name)
            .defaultIfEmpty(Visit(0, name, LocalDateTime.now()))
        val visitCountSingle = visitRepository.countVisit(name)
        return Mono.zip(
            visitCountSingle, lastVisitSingle,
            { count, lastVisit -> Hello(prefix.orEmpty(), name, count, lastVisit.createdAt) })
            .doOnError { e -> e.printStackTrace() }
            .flatMap { res -> visitRepository.addVisit(Visit(name)).thenReturn(res) }
    }
}
