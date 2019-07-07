package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
