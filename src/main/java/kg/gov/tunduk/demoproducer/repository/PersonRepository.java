package kg.gov.tunduk.demoproducer.repository;

import kg.gov.tunduk.demoproducer.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByPin(String pin);
}
