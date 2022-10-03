package com.projectuser.datajpapro.service;

import com.projectuser.datajpapro.dao.UserDAO;
import com.projectuser.datajpapro.exception.UserNotFoundException;
import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.repository.OrganizationRepository;
import com.projectuser.datajpapro.repository.UserRepository;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserDAO userDAO;

    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    public User createUser( User user, String organization) {
        Organization organization1 = organizationRepository.findByOrganizationName(organization);
        user.setOrganization(organization1);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUser( int id) {
        userRepository.deleteById( id);
    }

    public Optional<User> retrieveUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id+" "+"doesnot exists");

        return user;
    }

    public void update(User users){
        userRepository.save(users);
    }

    public Page<User> getPage( int records, int page) {
        return userDAO.getPagination(records, page);
    }

}
