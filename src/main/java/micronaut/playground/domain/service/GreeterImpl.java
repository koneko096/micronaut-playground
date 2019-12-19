package micronaut.playground.domain.service;

import io.reactivex.Maybe;
import io.reactivex.Single;
import micronaut.playground.client.model.Hello;
import micronaut.playground.config.TemplateConfiguration;
import micronaut.playground.repository.VisitRepository;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Singleton
public class GreeterImpl implements Greeter {

  private TemplateConfiguration configuration;
  private VisitRepository visitRepository;

  public GreeterImpl(TemplateConfiguration configuration, VisitRepository visitRepository) {
    this.configuration = configuration;
    this.visitRepository = visitRepository;
  }

  @Override
  public Single<Hello> greetHello(@NotEmpty String name) {
    Maybe<LocalDateTime> lastVisitSingle = Maybe
        .fromCallable(() -> visitRepository.lastVisit(name))
        .flatMap(v -> Maybe.just(v.orElse(null)));
    Single<Long> visitCountSingle = Single.just(name).map(visitRepository::countVisit);
    return Single.zip(visitCountSingle.materialize(), lastVisitSingle.materialize(),
        (count, lastVisit) -> new Hello(configuration.getPrefix(),
            name,
            count.getValue(),
            lastVisit.getValue()))
          .doOnSuccess(c -> visitRepository.addVisit(name));
  }
}
