package com.example;

import java.util.List;
import com.example.User;

public interface UserService {

   
    public void user(User user);

 
    public List<User> getUsers();
   
    public User getUserOne(String id);

    public void updateUser(String id,
    		 String password,
            String name);


    public void deleteUser(String id);

}
