package com.projectuser.datajpapro.user;

import com.projectuser.datajpapro.organization.Organization;
import com.projectuser.datajpapro.organization.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserDAO userDAO;

    public UserController(UserRepository repository, OrganizationRepository organizationRepository) {
        this.repository = repository;
        this.organizationRepository=organizationRepository;
    }

    @GetMapping("/user")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @PostMapping("/user/{organization}")
    public User createUser(@RequestBody User user,@PathVariable String organization){
        Organization organization1 = organizationRepository.findByOrganizationName(organization);
        user.setOrganization(organization1);
        User savedUser = repository.save(user);
        return savedUser;
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById( id);
    }

    @GetMapping("/user/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id+" "+"doesnot exists");

        return user;
    }

    @PutMapping("/user")
    public void update(@RequestBody User users){
        repository.save(users);
    }



    @GetMapping("/getPaginationEngineers")
    public Page<User> getPage(@RequestParam("records") int records, @RequestParam("page") int page) {
        return userDAO.getPagination(records, page);
    }


}
