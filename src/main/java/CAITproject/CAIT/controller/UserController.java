package CAITproject.CAIT.controller;

import CAITproject.CAIT.model.User;
import CAITproject.CAIT.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletResponse response){
        return userService.verify(user, response);
    }

    @PostMapping("/addUser")
    public String addingUser(@RequestBody User user){
        return userService.addingUser(user);
    }
}
