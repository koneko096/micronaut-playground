package micronaut.playground.domain;

import micronaut.playground.client.Hello;
import micronaut.playground.config.TemplateConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterImplTest {
  private TemplateConfiguration configuration;
  private GreeterImpl greeter;

  @BeforeEach
  void setUp() {
    configuration = new TemplateConfiguration();
    configuration.setPrefix("something");
    greeter = new GreeterImpl(configuration);
  }

  @Test
  void greetHello() {
    Hello result = greeter.greetHello("is wrong").blockingGet();
    assertEquals("something", result.getGreeting());
    assertEquals("is wrong", result.getName());
  }
}