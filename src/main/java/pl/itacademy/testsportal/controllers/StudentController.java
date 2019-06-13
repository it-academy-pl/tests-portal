package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path="/students", method = RequestMethod.GET)
    public ModelAndView allStudents() {
        logger.debug("getting all students");
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }
//    @RequestMapping(path="/addStudent", method = RequestMethod.GET)
//    public ModelAndView addStudent() {
//        logger.debug("Add student website opening");
//        return new ModelAndView("/addstudent.html");
//    }

    @RequestMapping(path="/student", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(path="/addStudent", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "result";
    }

//    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//    public String submit(@ModelAttribute("student")Student student,
//                         BindingResult result.html, ModelMap model) {
//        if (result.html.hasErrors()) {
//            System.out.println("error");
//            logger.error("Can't submit new Student to database");
//            return "error";
//        }
//        System.out.println("ok");
//        model.addAttribute("name", student.getName());
//        model.addAttribute("surname", student.getSurname());
//        model.addAttribute("email", student.getSurname());
//        model.addAttribute("password", student.getPassword());
//        logger.info("New student was added");
//        return "employeeView";
//    }
}
