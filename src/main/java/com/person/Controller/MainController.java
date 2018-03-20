package com.person.Controller;

import com.person.Entity.PersonEntity;
import com.person.Mapper.PersonMapper;
import com.person.Model.PersonModel;
import com.person.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private PersonRepository personRepository;

    @CrossOrigin
    @GetMapping(path = "/add")
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String location, @RequestParam String dob) {
        try {
            PersonModel personModel = new PersonModel();
            personModel.setName(name);
            personModel.setAge(age);
            personModel.setLocation(location);
            personModel.setDob(dob);
            personRepository.save(PersonMapper.mapPersonModelToPersonEntity(personModel));
            return new ResponseEntity<>("New User Saved",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<PersonModel>> getAllUsers() {
        Iterable<PersonEntity> personEntity = personRepository.findAll();
        if(personEntity != null)
            return new ResponseEntity<>(PersonMapper.mapPersonEnitiesToPersonModels(personEntity),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @CrossOrigin
    @GetMapping(path = "/find/{name}")
    public  ResponseEntity<PersonModel> FindSingleUser(@PathVariable String name) {
        PersonEntity personEntity = personRepository.findByName(name);
        if (personEntity != null) {
            return new ResponseEntity<>(PersonMapper.mapPersonEntityToPersonModel(personEntity),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping(path = "/edit/{name}")
    public  ResponseEntity<String> updateUser(@PathVariable String name, @RequestParam Integer age, @RequestParam String location, @RequestParam String dob) {
        try {
            PersonModel personModel = PersonMapper.mapPersonEntityToPersonModel(personRepository.findByName(name));
            personModel.setAge(age);
            personModel.setLocation(location);
            personModel.setDob(dob);
            personRepository.delete(personRepository.findByName(name));
            personRepository.save(PersonMapper.mapPersonModelToPersonEntity(personModel));
            return new ResponseEntity<>("Edit Success",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Edit Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/delete/{name}")
    public ResponseEntity<String> deleteUser(@PathVariable String name) {
        try {
            personRepository.delete(personRepository.findByName(name));
            return new ResponseEntity<>("Delete Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Delete Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
