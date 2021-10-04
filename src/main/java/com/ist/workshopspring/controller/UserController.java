package com.ist.workshopspring.controller;

import com.ist.workshopspring.entity.User;
import com.ist.workshopspring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    // This is commit Branch1
    @GetMapping(value = "/getallusers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> result = userRepository.findAll();
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try{
            User user1 = userRepository.save(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        }catch (Exception e){
             log.error("Error saving data!");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam String userId){
        try{
            userRepository.deleteById(Long.valueOf(userId));
            return new ResponseEntity<>("Deleted Success", HttpStatus.OK);
        }catch (Exception e){
            log.error("Error delete data {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
