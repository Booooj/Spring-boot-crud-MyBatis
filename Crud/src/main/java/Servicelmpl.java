package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.User;

@Service
public class Servicelmpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	
    @Override
    public void user(User user) {
    	 mapper.insertOne(user);
    }
   
    @Override
    public List<User> getUsers() {
        return mapper.findMany();
    }
   
    @Override
    public User getUserOne(String id) {
        return mapper.findOne(id);
    }
    
    @Override
    public void updateUser(String id,
            String password,
            String name) {
      mapper.update(id, password, name);
    }

    @Override
    public void deleteUser(String id) {
        int ?? = mapper.delete(id);
    }
    }

