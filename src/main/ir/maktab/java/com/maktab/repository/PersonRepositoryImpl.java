package com.maktab.repository;

import com.maktab.domains.Person;
import com.maktab.repository.base.BaseRepository;

public class PersonRepositoryImpl extends BaseRepository<Person, Long> {

    private static PersonRepositoryImpl personRepository;

    public static PersonRepositoryImpl getInstance() {
        if (personRepository == null) personRepository = new PersonRepositoryImpl();
        return personRepository;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

    public Person save(Person person) {
        return save(person);
    }
}
