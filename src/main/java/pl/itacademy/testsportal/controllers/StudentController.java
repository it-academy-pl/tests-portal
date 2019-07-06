package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.StudentService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@Transactional
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

/*
    @GetMapping("/students")
    public ModelAndView allStudents() {
        logger.debug("getting all students");
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }
*/

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") long id) {
        return studentService.getById(id).get();
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> getStudentByName(@RequestParam(name = "name") String name) {
        return studentService.getByName(name);
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

}