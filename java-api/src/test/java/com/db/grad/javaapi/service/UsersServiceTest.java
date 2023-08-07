package com.db.grad.javaapi.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @Test
    @DisplayName("Test registerUser")
    public void testRegisterUser() {
        Users user = new Users();
        user.setPassword("password");
        user.setUsername("username");
        doReturn(user).when(usersRepository).save(user);

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        Assertions.assertEquals(user, usersService.registerUser(user));
    }

    @Test
    @DisplayName("Test loadUserByUsername")
    public void testLoadUserByUsername() {
        Users user = new Users();
        user.setId(1);
        user.setUsername("mock");
        user.setPassword("password");
        user.setRole("ADMIN");
        doReturn(user).when(usersRepository).findUserByUsername("mock");

        UserBuilder userBuilder = User.withUsername(user.getUsername());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());

        Assertions.assertEquals(userBuilder.build(), usersService.loadUserByUsername("mock"));
    }
}
