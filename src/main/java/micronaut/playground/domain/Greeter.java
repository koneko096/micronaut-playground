package micronaut.playground.domain;

import io.reactivex.Single;
import micronaut.playground.client.Hello;

import javax.validation.constraints.NotEmpty;

public interface Greeter {
  Single<Hello> greetHello(@NotEmpty String name);
}
