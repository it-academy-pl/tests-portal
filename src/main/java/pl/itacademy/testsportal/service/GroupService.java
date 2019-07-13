package pl.itacademy.testsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.GroupRepository;
import pl.itacademy.testsportal.model.Group;

@Service
@Transactional
public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }
}
