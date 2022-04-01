package com.miu.edu.waalab2.controller;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.dto.PostDto;
import com.miu.edu.waalab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getPost(){

        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "someValue");
        return ResponseEntity.ok().headers(headers).body(postService.getById(id));
    }



    @GetMapping("/some")
    public String printSomething(@RequestParam("filter") String author){

        return ""+author;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void savePost( @RequestBody Post p){

        postService.save(p);
    }
}
