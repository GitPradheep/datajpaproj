package com.projectuser.datajpapro.service;
import com.projectuser.datajpapro.exception.UserAlreadyExist;
import com.projectuser.datajpapro.exception.UserNotFoundException;
import com.projectuser.datajpapro.repository.OrganizationRepository;
import com.projectuser.datajpapro.repository.UserRepository;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user) {
        User existingUser = (User) userRepository.findByEmailId(user.getEmailId()).orElse(null);
        if (existingUser==null){
            return userRepository.save(user);
        }
        else throw new UserAlreadyExist("User already exists!!");

    }



    public void deleteUser(int id) {
        userRepository.deleteById( id);
    }
    public User retrieveUser(int id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }
    public void update(User users){
        userRepository.save(users);
    }

}