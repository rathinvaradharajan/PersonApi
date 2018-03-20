package com.person.Mapper;

import com.person.Entity.PersonEntity;
import com.person.Model.PersonModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonMapper {

    private static Logger logger = Logger.getLogger(PersonMapper.class.getName());

    public static PersonModel mapPersonEntityToPersonModel(PersonEntity personEntity) {
        PersonModel personModel = null;
        try {
            if(personEntity != null) {
                personModel = new PersonModel();
                personModel.setName(personEntity.getName());
                personModel.setAge(personEntity.getAge());
                personModel.setLocation(personEntity.getLocation());
                personModel.setDob(personEntity.getDob().toString());
            }
        } catch (Exception e) {
            logger.info(" In mapPersonEntityToPersonModel -> Exception ->" + e.getMessage());
        }
        return personModel;
    }

    public static List<PersonModel> mapPersonEnitiesToPersonModels(Iterable<PersonEntity> personEntities) {
        List<PersonModel> personModels = null;
        try {
            if(personEntities != null) {
                personModels = new ArrayList<>();
                for (PersonEntity personEntity:personEntities) {
                    personModels.add(mapPersonEntityToPersonModel(personEntity));
                }
            }
        } catch (Exception e) {
            logger.info("In mapPersonEnitiesToPersonModels -> Exception -> "+e.getStackTrace().toString());
        }
        return personModels;
    }

    public static PersonEntity mapPersonModelToPersonEntity (PersonModel personModel) {
        PersonEntity personEntity = null;
        try {
            if (personModel != null) {
                personEntity = new PersonEntity();
                personEntity.setName(personModel.getName());
                personEntity.setAge(personModel.getAge());
                personEntity.setLocation(personModel.getLocation());
                personEntity.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(personModel.getDob()));
                System.out.println(personEntity.getDob());
            }
        } catch (Exception e) {
            logger.info("In mapPersonModelToPersonEntity -> Exception -> "+e.toString());
        }
        return personEntity;
    }
}
