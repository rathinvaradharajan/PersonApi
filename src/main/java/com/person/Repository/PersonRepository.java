package com.person.Repository;

import com.person.Entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    PersonEntity findByName(String name);
}
