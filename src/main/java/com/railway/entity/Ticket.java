package com.railway.entity;
import jakarta.persistence.*;
@Entity @Table(name="tickets")
public class Ticket {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name; private String email; private String source; private String destination; private String date;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getSource(){return source;} public void setSource(String source){this.source=source;}
    public String getDestination(){return destination;} public void setDestination(String destination){this.destination=destination;}
    public String getDate(){return date;} public void setDate(String date){this.date=date;}
}