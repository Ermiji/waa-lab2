package com.miu.edu.waalab2.service;

import com.miu.edu.waalab2.domain.User;
import com.miu.edu.waalab2.domain.dto.PostDto;
import com.miu.edu.waalab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto getById(long id);

    void save(User u);

    List<PostDto> findPostsById(Long id);

//    List<UserDto> getUsersById(long id);
}
