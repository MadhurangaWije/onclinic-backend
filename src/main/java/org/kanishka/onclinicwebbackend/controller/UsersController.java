package org.kanishka.onclinicwebbackend.controller;

import org.bson.types.ObjectId;
import org.kanishka.onclinicwebbackend.model.Users;
import org.kanishka.onclinicwebbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public List<Users> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{_id}")
    public Users getOne(@PathVariable ObjectId _id){
        Users user=userRepository.findBy_id(_id);
        if (user!=null){
            return user;
        }
        return new Users();
    }

    @PostMapping
    public Users addUser(@Valid @RequestBody Users user) throws Exception {
        return userRepository.save(user);
    }

}
