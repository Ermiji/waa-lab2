package com.miu.edu.waalab2.repository;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post,Long> {

    List<Post> findAll();

//    @Query(value = "SELECT * FROM POST WHERE name= :name", nativeQuery = true)
//    List<Post> findPostHaveUserMoreThan(long id);
//
//    @Query(value = "SELECT * FROM POST WHERE id= :id", nativeQuery = true)
//    List<PostDto> getPostsById(long id);


}
