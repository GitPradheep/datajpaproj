package com.projectuser.datajpapro.service;
import com.projectuser.datajpapro.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UserService {

    public List<User> retrieveAllUsersById(Pageable pageable);
    public User createUser(User user);
    public void deleteUser( int id);
    public User retrieveUser(int id);
    public void update(User users);

}
