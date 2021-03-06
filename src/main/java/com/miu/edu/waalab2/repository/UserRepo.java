package com.miu.edu.waalab2.repository;

import com.miu.edu.waalab2.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
}
