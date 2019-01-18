package com.willpiears.assignment1spring.service;

import com.willpiears.assignment1spring.domain.DvdEntry;
import com.willpiears.assignment1spring.domain.DvdEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdService
{
    @Autowired
    private DvdEntryRepository dvdEntryRepository;

    public List<DvdEntry> findAllEntries()
    {
        return this.dvdEntryRepository.findAll();
    }

    public DvdEntry findDvdEntryById(Integer id)
    {
        return this.dvdEntryRepository.findDvdEntryById(id);
    }
}