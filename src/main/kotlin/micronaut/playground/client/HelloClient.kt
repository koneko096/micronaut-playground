package micronaut.playground.client

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.core.async.annotation.SingleResult
import micronaut.playground.client.model.Hello
import reactor.core.publisher.Mono

@Client("/api/hello")
interface HelloClient {

    @Get("/{name}", consumes = [MediaType.APPLICATION_JSON])
    @SingleResult
    fun hello(name: String): Mono<Hello>
}