package com.projectuser.datajpapro.repository;
import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUserByOrganization(Organization organization, Pageable pageable);

}
