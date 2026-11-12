package com.railway.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.railway.entity.User;
import com.railway.repository.UserRepository;
@Controller
public class SignupController {
    @Autowired UserRepository userRepo;
    @GetMapping("/signup") public String showSignup(){ return "redirect:/signup.html"; }
    @PostMapping({"/createUser","/signup"})
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password){
        if(userRepo.findByEmail(email)!=null){ return "redirect:/signup.html?error=exists"; }
        User u=new User(); u.setName(name); u.setEmail(email); u.setPassword(password);
        userRepo.save(u);
        return "redirect:/login.html?success";
    }
}