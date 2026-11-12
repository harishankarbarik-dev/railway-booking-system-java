package com.railway.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.railway.entity.Ticket;
import com.railway.repository.TicketRepo;
@Controller
public class TicketController {
    @Autowired private TicketRepo tr;
    @PostMapping("/bookTicket")
    public ModelAndView ticket(@RequestParam("source") String source,
                               @RequestParam("destination") String destination,
                               @RequestParam("date") String date,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email){
        ModelAndView mv;
        if(source.equals(destination)){
            mv=new ModelAndView("same");
        } else {
            mv=new ModelAndView("ticket");
            Ticket t=new Ticket();
            t.setName(name); t.setDate(date); t.setDestination(destination); t.setSource(source); t.setEmail(email);
            Ticket tnew=tr.save(t);
            mv.addObject("name",tnew.getName());
            mv.addObject("email",tnew.getEmail());
            mv.addObject("source",tnew.getSource());
            mv.addObject("destination",tnew.getDestination());
            mv.addObject("date",tnew.getDate());
        }
        return mv;
    }
}