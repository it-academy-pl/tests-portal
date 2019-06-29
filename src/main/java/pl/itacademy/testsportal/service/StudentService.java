package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.StudentRepository;
import pl.itacademy.testsportal.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentDao;

    public StudentService(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public void addStudent(Student student) {
        studentDao.save(student);
    }
    public Student getStudent(Student student) {return student;}
    public Student getByName(String name) { return studentDao.findByName(name); }

}
