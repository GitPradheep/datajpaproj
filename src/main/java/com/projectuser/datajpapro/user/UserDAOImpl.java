package com.projectuser.datajpapro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDAOImpl implements UserDAO{
    @Autowired
    private UserRepository repository;

    @Override
    public Page<User> getPagination(int records, int page) {

        Pageable pageable = PageRequest.of(page, records);
        return repository.findAll(pageable);
    }

}
