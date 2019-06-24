package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.model.Task;
import pl.itacademy.testsportal.service.StudentService;
import pl.itacademy.testsportal.service.TaskService;
import pl.itacademy.testsportal.validate.StudentValidator;

import java.util.List;

@Controller
@Transactional
public class TaskControllers {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;

    public TaskControllers(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/task")
    public String taskForm(Model model) {
        logger.debug("new task");
        model.addAttribute("task", new Task());
        return "taskForm";
    }
//
//    @GetMapping("/student")
//    public String studentForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "studentForm";
//    }
//
    @PostMapping("/task")
    public String studentSubmit(@ModelAttribute Task task) {
        Student student = studentService.getByName(task.getStudentName());
        List<Task> tasks = student.getTasks();
        tasks.add(task);
        student.setTasks(tasks);
        for(Task ts:student.getTasks()){
            System.out.println(ts.getDescription());
        }
        studentService.addStudent(student);
        return "resultTask";
    }
}
