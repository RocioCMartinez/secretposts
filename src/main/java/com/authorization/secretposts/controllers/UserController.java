package com.authorization.secretposts.controllers;

import com.authorization.secretposts.models.SiteUser;
import com.authorization.secretposts.repos.SiteUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    SiteUserRepository siteUserRepository;

    @GetMapping("/")
    public String getLogin(){
        return "login.html";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, String userName, String password){

        // Make sure the password and user are correct!
        // First find the user
        SiteUser siteUser = siteUserRepository.findSiteUserByUserName(userName);

        if(siteUser == null){
            return new RedirectView("/");
        }
        // check if the stored password matches
        if(!BCrypt.checkpw(password, siteUser.getPassword())){
            return new RedirectView("/");
        }

        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);

        return new RedirectView("/posts");
    }

    @PostMapping("/signup")
    public RedirectView signup(String userName, String password) {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        SiteUser newUser = new SiteUser(userName, hashedPassword);
        siteUserRepository.save(newUser);

        return new RedirectView("/");
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return new RedirectView("/");
    }


}
