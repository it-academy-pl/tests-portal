package pl.itacademy.testsportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.model.Task;
import pl.itacademy.testsportal.service.StudentService;
import pl.itacademy.testsportal.service.TaskService;

import java.util.List;

@Controller
@Transactional
public class TaskController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;
    private TaskService taskService;

    public TaskController(StudentService studentService,
                          TaskService taskService) {
        this.studentService = studentService;
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public String taskForm(Model model) {
        logger.debug("new task");
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @PostMapping("/task")
    public String studentSubmit(@ModelAttribute Task task) {
        Student student = studentService.getByName(task.getStudentName());
        List<Task> tasks = student.getTasks();
        tasks.add(task);
        task.setStudent(student);

        taskService.saveTask(task);
        return "resultTask";
    }
}
