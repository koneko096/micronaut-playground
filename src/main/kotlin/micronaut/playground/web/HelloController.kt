package micronaut.playground.web

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import micronaut.playground.client.model.Hello
import micronaut.playground.domain.service.Greeter
import org.reactivestreams.Publisher

@Controller("/api/hello")
class HelloController(val greeter: Greeter) {

    @Get("/{name}")
    @ExecuteOn(TaskExecutors.IO)
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(name: String): Publisher<Hello> = greeter.greetHello(name)
}
