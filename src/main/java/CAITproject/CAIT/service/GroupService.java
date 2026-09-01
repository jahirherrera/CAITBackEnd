package CAITproject.CAIT.service;

import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.User;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    GroupRepo groupRepo;

    public void addingGroup(GroupDTO groupDTO){


        User user = userRepo.findByUsername(groupDTO.getUser_username());

        Group group = new Group(groupDTO.getName(), user );

        groupRepo.save(group);


    }

    public List<GroupDTO> getAllGroups(String username){
        User user = userRepo.findByUsername(username);

        if(user != null) {
            System.out.println(user.getGroup());
            return user.getGroup().stream().map(GroupDTO::new).toList();
        }else{
            throw new UsernameNotFoundException("user not found so sad");
        }
    }
}
