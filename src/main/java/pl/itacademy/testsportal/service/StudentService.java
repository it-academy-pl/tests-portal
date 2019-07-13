package pl.itacademy.testsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.StudentRepository;
import pl.itacademy.testsportal.model.Student;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private PasswordEncoder bCryptPasswordEncoder;
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          PasswordEncoder bCryptPasswordEncoder) {
        this.studentRepository = studentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        String hashedPassword = bCryptPasswordEncoder.encode(student.getPassword());
        student.setPassword(hashedPassword);
        student.setRepeatPassword(hashedPassword);

        studentRepository.save(student);
    }

    public Student getByName(String name) { return studentRepository.findByName(name); }

}
