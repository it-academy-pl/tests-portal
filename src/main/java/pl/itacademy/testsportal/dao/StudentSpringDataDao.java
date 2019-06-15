package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.itacademy.testsportal.model.Student;

import java.util.Optional;

public interface StudentSpringDataDao extends JpaRepository<Student, Long> {

    @Query("Select s from STUDENT s where name = :name")
    Optional<Student> findByName(@Param("name") String name);
}
