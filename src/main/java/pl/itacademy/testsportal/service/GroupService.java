package pl.itacademy.testsportal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itacademy.testsportal.dao.GroupRepository;
import pl.itacademy.testsportal.model.Group;

@Service
@Transactional
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
    }
}
