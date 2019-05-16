package pl.itacademy.testsportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path="/students", method = RequestMethod.GET)
    public ModelAndView allStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }
}
