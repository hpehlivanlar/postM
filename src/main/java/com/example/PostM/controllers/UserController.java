package com.example.PostM.controllers;

import com.example.PostM.entities.User;
import com.example.PostM.repos.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

private UserRepository userRepository;

    public  UserController(UserRepository userRepository){ this.userRepository=userRepository;}

    @GetMapping //tüm kullanıcıları listeleme
    public List<User> getAllUsers(){
    return  userRepository.findAll();
    }
    @PostMapping//yeni kullanıcı ekleme alanı
    public User createUser(@RequestBody User newUser){
    return  userRepository.save(newUser);
      /*  return userService.getAllUsers().stream().map(u -> new UserResponse(u)).toList();*/
    }

    @GetMapping("/{userId}") //burada kullanıcı ıd ile geri çağırma
    public User getOneUser(@PathVariable Long userId){
    //kulanıcı ahatası ekle
    return userRepository.findById((userId)).orElse(null);
    }

    @PutMapping("/{user}") //kullanıcı guncelleme ve set etme işlemi
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        Optional<User> user=userRepository.findById(userId);
        if (user.isPresent()){
            User foundUser=user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;

        }else {
            return null;
        }
    }
     @DeleteMapping("/{userId}")
     public void deleteOneUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
     }

}
