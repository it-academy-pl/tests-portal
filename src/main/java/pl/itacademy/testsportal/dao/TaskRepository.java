package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itacademy.testsportal.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
