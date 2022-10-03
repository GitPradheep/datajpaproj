package com.projectuser.datajpapro.controller;

import com.projectuser.datajpapro.service.UserService;
import com.projectuser.datajpapro.entities.User;
import com.projectuser.datajpapro.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> retrieveAllUsers(){
        return userService.retrieveAllUsers();
    }

    @PostMapping("/user/{organization}")
    public User createUser(@RequestBody User user,@PathVariable String organization){
        return userService.createUser(user,organization);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        return userService.retrieveUser(id);
    }

    @PutMapping("/user")
    public void update(@RequestBody User users){
        userService.update(users);
    }

    @GetMapping("/getPaginationEngineers")
    public Page<User> getPage(@RequestParam("records") int records, @RequestParam("page") int page) {
        return userService.getPage(records,page);
    }


}
