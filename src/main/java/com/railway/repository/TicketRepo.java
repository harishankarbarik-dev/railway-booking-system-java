package com.railway.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.railway.entity.Ticket;
public interface TicketRepo extends JpaRepository<Ticket, Long> {}