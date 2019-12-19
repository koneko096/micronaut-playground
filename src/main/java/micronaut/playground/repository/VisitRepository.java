package micronaut.playground.repository;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Optional;

public interface VisitRepository {
  Long countVisit(@NotEmpty String name);
  Optional<LocalDateTime> lastVisit(@NotEmpty String name);
  void addVisit(@NotEmpty String name);
}
