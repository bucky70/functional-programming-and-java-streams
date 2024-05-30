package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.User;
import com.in28minutes.rest.webservices.restful_web_services.UserDAOService;
import com.in28minutes.rest.webservices.restful_web_services.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {
    private UserDAOService userDAOService;
    @Autowired
    public UserResource(UserDAOService userDAOService){
        this.userDAOService=userDAOService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDAOService.findAll();
    }

    //http://localhost:8080/users

    //EntityModel
    //WebMVCLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
        User user=userDAOService.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("id : "+id);
        }
        EntityModel<User> entityModel=EntityModel.of(user);
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       userDAOService.save(user);
       URI location= ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(user.getId())
               .toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userDAOService.deleteUserById(id);
    }
}
