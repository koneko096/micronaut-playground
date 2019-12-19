package micronaut.playground.repository;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class VisitRepositoryImplTest {
  private static final String NAME = "kirito";

  @Inject
  private VisitRepositoryImpl repository;

  @Test
  void test() {
    assertEquals(0L, repository.countVisit(NAME));
    assertFalse(repository.lastVisit(NAME).isPresent());
    repository.addVisit(NAME);
    assertEquals(1L, repository.countVisit(NAME));
    assertTrue(repository.lastVisit(NAME).isPresent());
  }
}