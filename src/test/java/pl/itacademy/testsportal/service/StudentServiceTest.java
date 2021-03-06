package pl.itacademy.testsportal.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import pl.itacademy.testsportal.dao.StudentRepository;
import pl.itacademy.testsportal.model.Student;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    StudentRepository repository;

    StudentService studentService;
    @Mock
    PasswordEncoder passwordEncoder;
    @Before
    public void setUp() {
        studentService = new StudentService(repository, passwordEncoder);
    }

    @Test
    public void testExample() {
        studentService.addStudent(new Student("name", "surname", "email", "password"));
        assertThat(studentService.getAllStudents().size()).isEqualTo(4);
    }

    @Test
    public void testGetStudentByName() {
        assertThat(studentService.getByName("Staszek").getEmail()).isEqualTo("rubel@coin.ru");
    }
}
