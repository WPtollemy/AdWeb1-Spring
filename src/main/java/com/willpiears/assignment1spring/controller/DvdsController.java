package com.willpiears.assignment1spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.willpiears.assignment1spring.domain.DvdEntry;
import com.willpiears.assignment1spring.service.DvdService;

@RestController
public class DvdsController
{
    @Autowired
    private DvdService dvdService;

    @GetMapping ("/")
    public String testMapping () {
        return "Hello, World";
    }

    @GetMapping ("/dvds")
    public List<DvdEntry> retrieveMapping () {
        return dvdService.findAllEntries();
    }
}
