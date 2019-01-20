package com.willpiears.assignment1spring.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DvdEntryRepository extends CrudRepository <DvdEntry, Integer>
{
    @Override
    List <DvdEntry> findAll();

    DvdEntry findDvdEntryById(Integer id);

    List <DvdEntry> findDvdEntriesByTitle(String title);

    @Transactional
    void deleteDvdEntryById(Integer id);
}
