package micronaut.playground.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import micronaut.playground.client.Hello;
import micronaut.playground.domain.Greeter;

import javax.inject.Inject;

@Controller
public class HelloController {

  private Greeter greeter;

  @Inject
  public HelloController(Greeter greeter) {
    this.greeter = greeter;
  }

  @Get("/{name}")
  public Single<Hello> hello(String name) {
    return greeter.greetHello(name);
  }
}
