package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/students")
//    public ModelAndView allStudents() {
//        logger.debug("getting all students");
//        List<Student> students = studentService.getAllStudents();
//        return new ModelAndView("/students.html", "students", students);
//    }

    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam(name="name") String name){
        List<Student> list = studentService.getByName(name);
        if( list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/students/{id}") // REST
    @ResponseBody
    public Student getStudentById(@PathVariable("id") long id, @RequestHeader("User-Agent") String userAgent) {
        System.out.println("user is using as a rest client " + userAgent);
        return studentService.getById(id).get();
    }

    @GetMapping("/addStudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/students")
    public ResponseEntity<Void> studentSubmit(@RequestBody Student student) {


        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}