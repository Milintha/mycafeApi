package com.mycafe.mycafe_api.repository;

import com.mycafe.mycafe_api.model.loginmodel.Role;
import com.mycafe.mycafe_api.model.loginmodel.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);

}
