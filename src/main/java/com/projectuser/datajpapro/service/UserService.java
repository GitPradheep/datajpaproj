package com.projectuser.datajpapro.service;

import com.projectuser.datajpapro.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> retrieveAllUsers();

    public User createUser( User user, String organization);

    public void deleteUser( int id);

    public Optional<User> retrieveUser(int id);

    public void update(User users);



}
