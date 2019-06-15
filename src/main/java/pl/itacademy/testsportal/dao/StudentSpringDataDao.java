package pl.itacademy.testsportal.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

import java.util.Optional;

@Profile("springdata")
@Repository
public interface StudentSpringDataDao extends JpaRepository<Student, Long> {
    //Optional<Student> findByName(String name);
}
