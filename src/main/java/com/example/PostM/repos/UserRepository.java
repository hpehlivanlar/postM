package com.example.PostM.repos;

import com.example.PostM.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByUserName(String userName);

}
