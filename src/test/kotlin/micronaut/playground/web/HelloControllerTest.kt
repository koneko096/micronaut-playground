package micronaut.playground.web

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import micronaut.playground.client.HelloClient

@MicronautTest(transactional = false)
class HelloControllerTest(
    private val client: HelloClient
) : BehaviorSpec({

    given("the hello endpoint") {
        `when`("the greeter is called with Zay") {
            val result = client.hello("Zay").block()
            then("the greeting is Test") {
                result.greeting shouldBe "Test"
            }
            then("the name is Zay") {
                result.name shouldBe "Zay"
            }
            then("the count is 0") {
                result.count shouldBe 0
            }
        }
    }
})