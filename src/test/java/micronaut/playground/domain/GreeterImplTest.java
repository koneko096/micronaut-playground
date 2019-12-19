package micronaut.playground.domain;

import micronaut.playground.client.model.Hello;
import micronaut.playground.config.TemplateConfiguration;
import micronaut.playground.domain.service.GreeterImpl;
import micronaut.playground.repository.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GreeterImplTest {
  private TemplateConfiguration configuration;
  private GreeterImpl greeter;

  @Mock
  private VisitRepository visitRepository;

  @BeforeEach
  void setUp() {
    initMocks(this);
    configuration = new TemplateConfiguration();
    configuration.setPrefix("something");
    greeter = new GreeterImpl(configuration, visitRepository);
  }

  @Test
  void greetHello() {
    when(visitRepository.countVisit("is wrong")).thenReturn(2L);
    Hello result = greeter.greetHello("is wrong").blockingGet();
    assertEquals("something", result.getGreeting());
    assertEquals("is wrong", result.getName());
    assertEquals(2L, result.getCount());
  }
}