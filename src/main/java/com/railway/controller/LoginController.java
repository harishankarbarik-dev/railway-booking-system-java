package com.railway.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.railway.entity.User;
import com.railway.repository.UserRepository;
@Controller
public class LoginController {
    @Autowired UserRepository userRepo;
    @GetMapping("/login") public String showLogin(){ return "redirect:/login.html"; }
    @PostMapping({"/login","/validateUser"})
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password){
        ModelAndView mv=new ModelAndView();
        User u=userRepo.findByEmail(email);
        if(u!=null && u.getPassword().equals(password)){
            mv.setViewName("redirect:/book.html");
        } else {
            mv.setViewName("wrong");
        }
        return mv;
    }
}