package com.miu.edu.waalab2.domain.dto;

import com.miu.edu.waalab2.domain.Post;
import com.miu.edu.waalab2.domain.User;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UserDto {

    long id;
    String name;

}
