package micronaut.playground.domain.service;

import io.reactivex.Single;
import micronaut.playground.client.model.Hello;

import javax.validation.constraints.NotEmpty;

public interface Greeter {
  Single<Hello> greetHello(@NotEmpty String name);
}
