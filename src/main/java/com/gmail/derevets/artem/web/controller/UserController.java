package com.gmail.derevets.artem.web.controller;

import com.gmail.derevets.artem.web.dto.cassandra.UserCassandra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(value = "/userManagement")
public class UserController {

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getUser(@PathVariable("email") String email) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> user = restTemplate.getForEntity("http://localhost:8081/auth/user/" + email, String.class);
        return user.getBody();
    }


}
