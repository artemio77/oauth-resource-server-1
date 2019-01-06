package com.gmail.derevets.artem.web.controller;

import com.gmail.derevets.artem.web.dto.User;
import com.gmail.derevets.artem.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/resource/user")
public class UserController {


  /*  @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    @PreAuthorize("#oauth2.hasScope('write') and #oauth2.hasScope('read')")
    @ResponseBody
    public ResponseEntity<User> createMongoUser(@RequestBody User user) {
        log.info("userJSON, {}", user);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }*/

}



