package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import pl.itacademy.testsportal.dao.TaskRepository;
import pl.itacademy.testsportal.model.Task;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

}
