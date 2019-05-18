package pl.itacademy.testsportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

import java.util.List;

@Repository
@Profile({"prod", "h2"})
public class StudentSpringJdbcDao implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentSpringJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM STUDENTS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setEmail(rs.getString("email"));
            return student;
        });

    }
}
