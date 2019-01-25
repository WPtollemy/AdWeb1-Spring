package com.willpiears.assignment1spring.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DvdEntryRepository extends CrudRepository <DvdEntry, Integer>
{
    @Override
    List <DvdEntry> findAll();

    DvdEntry findDvdEntryById(Integer id);

    List <DvdEntry> findByTitleContaining(String title);

    @Transactional
    void deleteDvdEntryById(Integer id);
}
