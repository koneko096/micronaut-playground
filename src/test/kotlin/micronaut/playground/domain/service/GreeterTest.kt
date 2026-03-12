package micronaut.playground.domain.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import micronaut.playground.domain.entity.Visit
import micronaut.playground.repository.VisitRepository
import reactor.core.publisher.Mono


class GreeterTest : BehaviorSpec({

    val repository = mockk<VisitRepository>()
    val greeter = GreeterImpl(repository)

    every { repository.lastVisit(any()) } returns Mono.just(Visit(""))
    every { repository.countVisit(any()) } returns Mono.just(0)
    every { repository.addVisit(any()) } returns Mono.empty()

    given("the greeter") {
        `when`("the service is called with Aan") {
            val result = greeter.greetHello("Aan")
            then("the result is Aan") {
                result.block().name shouldBe "Aan"
            }
        }

        `when`("the service is called with Zay") {
            val result = greeter.greetHello("Zay")
            then("the result is Zay") {
                result.block().name shouldBe "Zay"
            }
        }
    }
})