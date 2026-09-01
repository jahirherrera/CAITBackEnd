package CAITproject.CAIT.service;

import CAITproject.CAIT.model.User;
import CAITproject.CAIT.repo.UserRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    private final BCryptPasswordEncoder encoder; //we create an object, this is already include in spring security

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder){
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public String verify(User user, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {

            Cookie cookie = new Cookie("token", jwtService.generateToken(user.getUsername()));

            cookie.setSecure(true); //HTTP is allowed
            cookie.setHttpOnly(true); // frontend cant read or modify it
            cookie.setMaxAge(60 * 60 * 24); //expiration time (1day)
            cookie.setPath("/"); //send all to endpoints
            cookie.setAttribute("SameSite", "None"); //cross-origin from frontend to backend\

            response.addCookie(cookie);


            return "login successful";

        }
        return "failed";
    }

    public String addingUser(User user){
        User newUser = userRepo.findByUsername(user.getUsername());
        User userEmail = userRepo.findByEmail(user.getEmail());

        user.setPassword(encoder.encode(user.getPassword()));

        if(newUser == null){
            if(userEmail==null){
                userRepo.save(user);
                return "User Saved!";
            }else{
                return "Email already Registered";
            }
        }else{
            return "Username Taken";
        }
    }
}
