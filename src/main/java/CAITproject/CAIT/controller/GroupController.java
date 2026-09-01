package CAITproject.CAIT.controller;


import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.service.GroupService;
import CAITproject.CAIT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("addGroup")
    public void addingGroup(@RequestBody GroupDTO groupDTO){
        groupService.addingGroup(groupDTO);

    }

    @GetMapping("/groups/{username}")
    public List<GroupDTO> getAllGroup(@PathVariable("username") String username){
        return groupService.getAllGroups(username);
    }
}
