package pl.itacademy.testsportal.dao;

import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentInMemoryDao implements StudentDao {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Mikolaj", "Kopernik", "kopernik@torun.pl", "qwerty"));
        students.add(new Student("Krzysztof", "Jarzyna", "jarzyna@ze.szczecina.pl", "grucha"));
        students.add(new Student("Robert", "Lewandowski", "robert@bayern.com", "5goli"));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}
