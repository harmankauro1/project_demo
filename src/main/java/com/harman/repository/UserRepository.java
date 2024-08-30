package com.harman.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harman.entity.UserPojo;

@Repository
public interface UserRepository extends JpaRepository<UserPojo, Long> {
}
