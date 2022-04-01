package com.miu.edu.waalab2.service;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.User;
import com.miu.edu.waalab2.domain.dto.PostDto;
import com.miu.edu.waalab2.domain.dto.UserDto;
import com.miu.edu.waalab2.helper.ListMapper;
import com.miu.edu.waalab2.repository.PostRepo;
import com.miu.edu.waalab2.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperUserToDto.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map( userRepo.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public void save(User u) {

        userRepo.save(u);
        u.getPosts().stream()
                .map(p -> {p.setUser(u); return p;})
                .forEach(p -> postRepo.save(p));
    }

    @Override
    public List<PostDto> findPostsById(Long id) {
        return (List<PostDto>)listMapperPostToDto.mapList(userRepo.findById(id).get().getPosts(), new PostDto());
    }

//    @Override
//    public List<UserDto> getUsersById(long id) {
//        return modelMapper(userRepo.findById(id).orElse(null), UserDto.class);
//    }
}
