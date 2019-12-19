package micronaut.playground.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("template")
public class TemplateConfiguration {
  private String prefix;

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
}
