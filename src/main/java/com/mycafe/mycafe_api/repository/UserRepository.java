package com.mycafe.mycafe_api.repository;

import com.mycafe.mycafe_api.model.loginmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Integer> userIds);

    Optional<User> findByUsername(String username);

    Optional<User> findByCanteen(String canteen);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);



    //find role
    @Query(value = "SELECT r.name FROM roles r where r.role_id in"
            +" (select role_id from user_roles ur where ur.user_id=:id )",nativeQuery = true)
    String getRoleNameById(@Param("id") Long id);

    //Get owner list
    @Query(value = "SELECT * FROM users u WHERE u.user_id IN " +
            "        (SELECT ur.user_id FROM  user_roles ur WHERE ur.role_id IN " +
            "        (SELECT r.role_id FROM roles r WHERE r.name=:roleName))", nativeQuery = true)
    List<User> getOwnerListByRoleName(@Param("roleName") String roleName);

    //Delete Owner
    String deleteById(String key);


}

