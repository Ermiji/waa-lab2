package com.miu.edu.waalab2.service;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.dto.PostDto;
import com.miu.edu.waalab2.helper.ListMapper;
import com.miu.edu.waalab2.repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {

        return modelMapper.map( postRepo.findById(id).orElse(null), PostDto.class);
    }

    @Override
    public void save(Post p) {

        postRepo.save(p);
    }

//    @Override
//    public List<PostDto> getPostsById(long id) {
//        return modelMapper(postRepo.findById(id).orElse(null), PostDto.class);
//    }
}
