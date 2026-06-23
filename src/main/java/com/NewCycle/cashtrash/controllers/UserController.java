package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.request.RequestPostUser;
import com.NewCycle.cashtrash.dtos.request.RequestPutUser;
import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>>findAll(){
        List<User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User>findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody @Valid RequestPostUser requestPostUser){
        User obj = userService.insert(requestPostUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid RequestPutUser requestPutUser){
        return ResponseEntity.ok().body(userService.update(id, requestPutUser));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
