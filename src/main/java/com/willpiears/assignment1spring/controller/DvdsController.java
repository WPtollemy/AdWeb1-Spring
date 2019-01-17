package com.willpiears.assignment1spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DvdsController
{
    @GetMapping ("/")
    public String testMapping () {
        return "Hello, World";
    }
}
