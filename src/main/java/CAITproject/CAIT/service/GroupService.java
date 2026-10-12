package CAITproject.CAIT.service;

import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.User;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.QuestionRepo;
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

    @Autowired
    QuestionRepo questionRepo;

    public void addingGroup(GroupDTO groupDTO){


        User user = userRepo.findByUsername(groupDTO.username());

        Group group = new Group(groupDTO.name(), user );

        groupRepo.save(group);


    }

    public void deleting(int id){

        questionRepo.deleteAllQuestionFromGroup(id);

        groupRepo.deleteById(id);
    }

    public List<GroupDTO> getAllGroups(String username){
        User user = userRepo.findByUsername(username);

        if(user != null) {
            return user.getGroup().stream().map(group -> new GroupDTO(group.getId(), group.getName(), group.getNextReview(),group.getUser().getUsername())).toList();
        }else{
            throw new UsernameNotFoundException("user not found so sad");
        }
    }
}
