package com.projectuser.datajpapro.user;

import com.projectuser.datajpapro.organization.Organization;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    Page<User> getPagination(int records, int page);
}
