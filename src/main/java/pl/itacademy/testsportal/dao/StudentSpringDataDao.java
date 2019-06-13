package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itacademy.testsportal.model.Student;

public interface StudentSpringDataDao extends JpaRepository<Student, Long> {

}
