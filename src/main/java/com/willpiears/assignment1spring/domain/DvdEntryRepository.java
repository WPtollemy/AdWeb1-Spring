package com.willpiears.assignment1spring.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DvdEntryRepository extends CrudRepository <DvdEntry, Integer>
{
    @Override
    List <DvdEntry> findAll();
}
