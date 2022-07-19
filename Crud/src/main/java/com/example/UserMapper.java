package com.example;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.User;

@Mapper
public interface UserMapper {

   
    public int insertOne(User user);
    
    public List<User> findMany();
 
    public User findOne(String id);
  
    public void update(@Param("id") String id,
            @Param("password") String password,
            @Param("name") String name);

    public int delete(@Param("id") String id);
}
