package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import pl.itacademy.testsportal.dao.StudentSpringDataDao;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.model.Task;

import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;

@Service
@Transactional
public class TaskService {
    private StudentSpringDataDao studentDao;

    public TaskService(StudentSpringDataDao studentDao) {
        this.studentDao = studentDao;
    }


}
