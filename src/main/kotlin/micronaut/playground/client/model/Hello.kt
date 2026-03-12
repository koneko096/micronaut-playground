package micronaut.playground.client.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDateTime

@Introspected
@Serdeable
data class Hello(val greeting: String, val name: String, val count: Long, val lastVisit: LocalDateTime)
