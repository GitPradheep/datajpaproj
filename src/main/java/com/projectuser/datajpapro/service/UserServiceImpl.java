package com.projectuser.datajpapro.service;

import com.projectuser.datajpapro.exception.UserAlreadyExistException;
import com.projectuser.datajpapro.exception.UserNotFoundException;
import com.projectuser.datajpapro.repository.OrganizationRepository;
import com.projectuser.datajpapro.repository.UserRepository;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    public List<User> retrieveAllUsersById(Pageable pageable) {
        return userRepository.findAll(pageable).getContent().stream().collect(Collectors.toList());
    }

    public User createUser(User user) {
        User existingUser = userRepository.findByEmailId(user.getEmailId()).orElse(null);
        if (existingUser == null) {
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistException("User already exists!!");
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User retrieveUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void update(User users) {
        userRepository.save(users);
    }

}