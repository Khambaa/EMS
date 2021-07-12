package com.catalyst.assignment.service;

import com.catalyst.assignment.entities.Roles;
import com.catalyst.assignment.entities.User;
import com.catalyst.assignment.exceptions.AppRuntimeException;
import com.catalyst.assignment.exceptions.ErrorCode;
import com.catalyst.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User registerUser(User user) {
        Set<Roles> roles=new HashSet<Roles>();
        user.getRoleIds().stream().forEach(x->{
            roles.add(new Roles(x));
        });
        user.setRoles(roles);
        if(userRepository.getUserByEmail(user.getEmail())!=null){
            throw new AppRuntimeException(null, ErrorCode.BAD_REQUEST,"User already exists with this email.");
        }
        return userRepository.save(user);

    }

    public void unRegisterUser(User user) {
        userRepository.delete(user);
    }
}
