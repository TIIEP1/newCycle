package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.dtos.request.RequestPostUser;
import com.NewCycle.cashtrash.dtos.request.RequestPutUser;
import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User insert(RequestPostUser postUser){
        User newUser = new User(postUser.getName(),postUser.getEmail(),
                postUser.getPassword(),postUser.getType(), postUser.getDateNasc(), postUser.getCfp());
       return userRepository.save(newUser);
    }

    public User update(Long id, RequestPutUser postUser){
        User oldUser = findById(id);
        oldUser.setName(postUser.getName());
        oldUser.setEmail(postUser.getEmail());
        oldUser.setCfp(postUser.getCfp());
        oldUser.setDateNasc(postUser.getDateNasc());
        oldUser.setType(postUser.getType());
        return userRepository.save(oldUser);
    }

    public void delete(Long id){
        User userToDelete = findById(id);
        userRepository.delete(userToDelete);
    }
}
