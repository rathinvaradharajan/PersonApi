package com.person.Controller;

import com.person.Entity.PersonEntity;
import com.person.Model.PersonModel;
import com.person.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class PingController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/ping")
    public ResponseEntity<String> HealthCheck() {
        try {
            Iterable<PersonEntity> personEntity= personRepository.findAll();
            return new ResponseEntity<>("Database live", HttpStatus.OK);
        } catch (Exception e) {
            String report = "Database cannot be reached";
            return new ResponseEntity<>(report, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
