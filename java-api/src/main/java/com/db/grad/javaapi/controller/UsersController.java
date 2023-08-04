package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.entity.JwtRequest;
import com.db.grad.javaapi.entity.JwtResponse;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.service.UsersService;
import com.db.grad.javaapi.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1/auth")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(403).body("A username or password of that value can not be found.");
        }

        UserDetails user = usersService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Users user) {
        try {
            usersService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("HERE");
            return ResponseEntity.ok(usersService.registerUser(user));
        }
        return ResponseEntity.status(409).body("Username already exists.");
    }


}
