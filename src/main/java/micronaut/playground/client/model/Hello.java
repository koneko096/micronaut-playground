package micronaut.playground.client.model;

import io.micronaut.core.annotation.Introspected;

import java.time.LocalDateTime;

@Introspected
public class Hello {
  private String greeting;
  private String name;
  private Long count;

  private LocalDateTime lastVisit;

  public Hello(String greeting, String name, Long count, LocalDateTime lastVisit) {
    this.greeting = greeting;
    this.name = name;
    this.count = count;
    this.lastVisit = lastVisit;
  }

  public LocalDateTime getLastVisit() {
    return lastVisit;
  }

  public void setLastVisit(LocalDateTime lastVisit) {
    this.lastVisit = lastVisit;
  }

  public String getGreeting() {
    return greeting;
  }

  public Long getCount() {
    return count;
  }

  public String getName() {
    return name;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCount(Long count) {
    this.count = count;
  }
}
