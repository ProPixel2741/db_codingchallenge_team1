package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.entity.JwtResponse;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.UsersService;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import com.db.grad.javaapi.entity.JwtRequest;
import com.db.grad.javaapi.utils.JwtUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootTest
@RunWith(SpringRunner.class)
class UsersControllerTest {

    @Autowired
    private UsersController usersController;

    @MockBean
    private UsersService usersService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private AuthenticationManager authenticationManager;


    @Test
    @DisplayName("Test login")
    public void testLogin() throws Exception {
        Users user = new Users();
        user.setId(1);
        user.setUsername("mock");
        user.setPassword("mock");
        user.setRole("");

        UserBuilder userBuilder = User.withUsername("mock");
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());

        doReturn(userBuilder.build()).when(usersService).loadUserByUsername("mock");
        doReturn("1").when(jwtUtil).generateToken(userBuilder.build());
        doReturn(null).when(authenticationManager).authenticate(new UsernamePasswordAuthenticationToken("mock", ""));

        Assertions.assertEquals(ResponseEntity.ok(new JwtResponse("1")).getStatusCode(), usersController.login(new JwtRequest("mock", "")).getStatusCode());
    }

    @Test
    @DisplayName("Test register")
    public void testRegister() {
        Users user = new Users();
        user.setUsername("mock");
        user.setPassword("password");
        user.setRole("ADMIN");
        doThrow(new UsernameNotFoundException(user.getUsername())).when(usersService).loadUserByUsername("mock");
        Assertions.assertEquals(ResponseEntity.ok(usersService.registerUser(user)), usersController.register(user));
    }

    @Test
    @DisplayName("Test register SAD")
    public void testRegisterFails() {
        Users user = new Users();
        user.setUsername("mock");
        user.setPassword("password");
        user.setRole("ADMIN");
        doReturn(null).when(usersService).loadUserByUsername("mock");
        Assertions.assertEquals(ResponseEntity.status(409).body("Username already exists.").getStatusCode(), usersController.register(user).getStatusCode());
    }
}