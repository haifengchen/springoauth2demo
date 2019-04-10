package com.haifeng.account.repository;

import com.haifeng.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);
}
