package com.matrixglitch.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private  UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GET
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }


    //POST
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Delete a user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
         service.deleteById(id);
    }
}
