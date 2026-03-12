package micronaut.playground.domain.service

import jakarta.validation.constraints.NotEmpty
import micronaut.playground.client.model.Hello
import reactor.core.publisher.Mono

interface Greeter {
    fun greetHello(@NotEmpty name: String): Mono<Hello>
}