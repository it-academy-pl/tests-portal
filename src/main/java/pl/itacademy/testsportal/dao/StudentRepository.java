package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s from Student s where name = :name")
    Student findByName(@Param("name") String name);
}
