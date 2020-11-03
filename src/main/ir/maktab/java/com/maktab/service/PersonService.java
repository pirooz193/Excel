package com.maktab.service;

import com.maktab.domains.*;
import com.maktab.repository.*;

public class PersonService {
    PersonRepositoryImpl personRepository = PersonRepositoryImpl.getInstance();

    public Person save(Person person){
        return personRepository.save(person);
    }
}
