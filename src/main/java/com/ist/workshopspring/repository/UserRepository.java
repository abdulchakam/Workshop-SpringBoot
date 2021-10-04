package com.ist.workshopspring.repository;

import com.ist.workshopspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
