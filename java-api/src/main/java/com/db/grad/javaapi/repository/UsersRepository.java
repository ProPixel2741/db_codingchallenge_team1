package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(nativeQuery = true, value = "select * from users where username=:uname")
    Users findUserByUsername(String uname);

}
