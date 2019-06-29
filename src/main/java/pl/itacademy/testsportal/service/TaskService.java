package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import pl.itacademy.testsportal.dao.TaskRepository;
import pl.itacademy.testsportal.model.Task;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    private TaskRepository taskDao;

    public TaskService(TaskRepository taskDao) {
        this.taskDao = taskDao;
    }

    public void saveTask(Task task) {
        taskDao.save(task);
    }

}
