package gr.opensourceuom.presentation.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByLastName(String name);

    Optional<Student> findByFirstName(String name);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
}
