package com.miu.edu.waalab2.controller;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.User;
import com.miu.edu.waalab2.domain.dto.PostDto;
import com.miu.edu.waalab2.domain.dto.UserDto;
import com.miu.edu.waalab2.service.PostService;
import com.miu.edu.waalab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "someValue");
        return ResponseEntity.ok().headers(headers).body(userService.getById(id));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDto>> getUserPostsById(@PathVariable("id")Long id){
        return ResponseEntity.ok(userService.findPostsById(id));
    }



    @GetMapping("/some")
    public String printSomething(@RequestParam("filter") String name){
        return ""+name;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser( @RequestBody User u) {
        userService.save(u);


    }
}
