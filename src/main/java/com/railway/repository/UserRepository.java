package com.railway.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.railway.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}