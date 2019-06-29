package pl.itacademy.testsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.StudentRepository;
import pl.itacademy.testsportal.model.Student;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getByName(String name) {
        return studentRepository.findByName(name);
    }


}
