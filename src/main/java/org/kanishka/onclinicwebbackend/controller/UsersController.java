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
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public List<Users> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{email}")
    public Users getOne(@PathVariable String email){

        Users user=userRepository.findByEmail(email).get();
        if (user!=null){
            return user;
        }
        return new Users();
    }

    @PostMapping
    public Users addUser(@Valid @RequestBody Users user) throws Exception {
        return userRepository.save(user);
    }

    @PutMapping("{email}")
    public Users updateUser(@PathVariable String email, @RequestBody Users user){
        return userRepository.save(user);
    }

}
