package micronaut.playground.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import javax.validation.constraints.NotEmpty;

@Client("/")
public interface HelloClient {

  @Get("/{name}")
  Single<Hello> hello(@NotEmpty String name);
}
