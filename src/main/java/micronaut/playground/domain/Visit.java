package micronaut.playground.domain;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Introspected
@Entity
@Table(name = "visit")
public class Visit {

  public Visit(@NotEmpty String name) {
    this.name = name;
  }

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getTime() {
    return createdAt;
  }

  public void setTime(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
