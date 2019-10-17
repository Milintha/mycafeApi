package com.mycafe.mycafe_api.repository;


import com.mycafe.mycafe_api.model.loginmodel.PasswordResetTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetTokenEntity,Long> {

    PasswordResetTokenEntity findByToken(String token);
}
