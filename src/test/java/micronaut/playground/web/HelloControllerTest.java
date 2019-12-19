package micronaut.playground.web;

import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import io.reactivex.Single;
import micronaut.playground.client.Hello;
import micronaut.playground.client.HelloClient;
import micronaut.playground.domain.Greeter;
import micronaut.playground.domain.GreeterImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@MicronautTest
class HelloControllerTest {

  @Inject
  private Greeter greeter;

  @Inject
  private HelloClient client;

  @AfterEach
  void tearDown() {
    verifyNoMoreInteractions(greeter);
  }

  @Test
  void hello() {
    when(greeter.greetHello("gukguk"))
        .thenReturn(Single.just(new Hello("Test", "gukguk", 1L, LocalDateTime.now())));

    Hello response = client.hello("gukguk").blockingGet();
    assertEquals("Test", response.getGreeting());
    assertEquals("gukguk", response.getName());

    verify(greeter).greetHello("gukguk");
  }

  @MockBean(GreeterImpl.class)
  Greeter greeter() {
    return mock(Greeter.class);
  }
}