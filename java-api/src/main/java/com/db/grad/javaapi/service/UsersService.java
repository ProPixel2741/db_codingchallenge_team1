package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Error: User not found.");
        UserBuilder userBuilder = User.withUsername(username);
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());

        return userBuilder.build();
    }

    public Users registerUser(Users user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return usersRepo.save(user);
    }
}
