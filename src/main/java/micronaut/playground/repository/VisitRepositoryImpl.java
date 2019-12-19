package micronaut.playground.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import micronaut.playground.domain.entity.Visit;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Optional;

@Singleton
public class VisitRepositoryImpl implements VisitRepository {

  @PersistenceContext
  private EntityManager em;

  public VisitRepositoryImpl(@CurrentSession EntityManager em) {
    this.em = em;
  }

  @Override
  @Transactional(readOnly = true)
  public Long countVisit(@NotEmpty String name) {
    TypedQuery<Long> count = em
        .createQuery("SELECT COUNT(*) FROM Visit v WHERE v.name IS :name", Long.class)
        .setParameter("name", name);
    return count.getSingleResult();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<LocalDateTime> lastVisit(@NotEmpty String name) {
    TypedQuery<LocalDateTime> last = em
        .createQuery("SELECT v.createdAt FROM Visit v WHERE v.name IS :name "
            + "ORDER BY v.createdAt DESC", LocalDateTime.class)
        .setParameter("name", name)
        .setMaxResults(1);
    return last.getResultList().stream().findFirst();
  }


  @Override
  @Transactional
  public void addVisit(@NotEmpty String name) {
    this.em.persist(new Visit(name));
  }
}
