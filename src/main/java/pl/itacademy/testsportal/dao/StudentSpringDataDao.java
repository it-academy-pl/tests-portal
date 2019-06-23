package pl.itacademy.testsportal.dao;

import org.hibernate.annotations.Parameter;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

import java.util.Optional;

@Profile("springdata")
@Repository
public interface StudentSpringDataDao extends JpaRepository<Student, Long> {
    @Query("Select s from STUDENT s where name = :name")
    Student findByName(@Param("name") String name);
}
