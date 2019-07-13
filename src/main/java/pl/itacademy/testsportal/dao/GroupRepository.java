package pl.itacademy.testsportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("Select s from GROUPS s where name = :name")
    Group findByName(@Param("name") String name);


}
