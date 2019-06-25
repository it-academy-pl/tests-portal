package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.StudentRepository;
import pl.itacademy.testsportal.model.Student;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getByName(String name) {
        return studentRepository.findByName(name);
    }


}
