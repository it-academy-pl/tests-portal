package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ModelAndView allStudents() {
        logger.debug("getting all students");
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }

    @GetMapping("/addStudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/addStudent")
    public String studentSubmit(@ModelAttribute @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "studentForm";
        }
        studentService.addStudent(student);
        return "result";
    }

    @GetMapping("/task")
    public String getTask() {
        return "task";
    }
}