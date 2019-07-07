package pl.itacademy.testsportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.service.GroupService;
import pl.itacademy.testsportal.service.StudentService;

@Controller
@Transactional
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
}
