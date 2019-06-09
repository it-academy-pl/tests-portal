package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.StudentDao;
import pl.itacademy.testsportal.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }


}
