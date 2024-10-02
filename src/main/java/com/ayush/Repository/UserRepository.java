package com.ayush.Repository;

import com.ayush.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> { /* It provides us methods for all CRUD operations... */
    public User findByEmail(String email);
}
