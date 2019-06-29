package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import pl.itacademy.testsportal.dao.TaskDao;
import pl.itacademy.testsportal.model.Task;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    private TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void saveTask(Task task) {
        taskDao.save(task);
    }

}
