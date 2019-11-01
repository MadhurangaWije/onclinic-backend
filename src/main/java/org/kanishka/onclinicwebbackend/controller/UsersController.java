package org.kanishka.onclinicwebbackend.controller;

import org.bson.types.ObjectId;
import org.kanishka.onclinicwebbackend.model.Roles;
import org.kanishka.onclinicwebbackend.model.Users;
import org.kanishka.onclinicwebbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "https://4409a0f0.ngrok.io")
public class UsersController {

    @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Users> getAll(){
        return  userRepository.findAll();
    }

    @GetMapping("{email}")
    public Users getOne(@PathVariable String email){
        return userRepository.findByEmail(email).orElseGet(Users::new);
    }

    @PostMapping
    public Users addUser(@Valid @RequestBody Users user) {

        user.setPassword(passwordEncoder.encode(user.getFirstName()));
        if (user.isHealthCareProfessional()){
            String response=restTemplate.getForObject("http://www.srilankamedicalcouncil.org/registry.php?registry=5&initials=&last_name=&other_name=&reg_no=33787&nic=871881219&part_of_address=&search=Search",String.class);
            boolean found;
            if (response!=null){
                found=response.contains("<h2>Found 1 result(s)</h2>");
                if (found){
                    user.setRoles(Arrays.asList(Roles.ROLE_DOCTOR));
                }else{

                }
            }
        }else{
            user.setRoles(Arrays.asList(Roles.ROLE_GENERAL));
        }
        return userRepository.save(user);
    }


    @PutMapping("{email}")
    public Users updateUser(@PathVariable String email, @RequestBody Users user){

        return userRepository.save(user);
    }

}
