package com.projectuser.datajpapro.dao;

import com.projectuser.datajpapro.entities.User;
import org.springframework.data.domain.Page;


public interface UserDAO {

    Page<User> getPagination(int records, int page);
}
