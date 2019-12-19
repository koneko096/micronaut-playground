package micronaut.playground.domain;

import io.reactivex.Single;
import micronaut.playground.client.Hello;
import micronaut.playground.config.TemplateConfiguration;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;

@Singleton
public class GreeterImpl implements Greeter {

  private TemplateConfiguration configuration;

  @Inject
  public GreeterImpl(TemplateConfiguration configuration) {
    this.configuration = configuration;
  }

  @Override
  public Single<Hello> greetHello(@NotEmpty String name) {
    return Single.just(new Hello(configuration.getPrefix(), name));
  }
}
