package com.miu.edu.waalab2.service;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto getById(long id);

    void save(Post p);

//    List<PostDto> getPostsById(long id);

}
