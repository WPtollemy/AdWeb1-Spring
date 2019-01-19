package com.willpiears.assignment1spring.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.willpiears.assignment1spring.domain.DvdEntry;
import com.willpiears.assignment1spring.service.DvdService;
import org.springframework.stereotype.Controller;

@Controller
public class DvdsController
{
    @Autowired
    private DvdService dvdService;

    private static final String DVD_TEMPLATE = "dvds";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    @GetMapping ("/")
    public String displayDvds (Model model) {
        model.addAttribute ("entries", this.dvdService.findAllEntries());
        model.addAttribute ("newEntry", new DvdEntry());

        return DVD_TEMPLATE;
    }

    @ResponseBody
    @GetMapping ("/dvds")
    public List<DvdEntry> retrieveAllDvds () {
        return dvdService.findAllEntries();
    }

    @ResponseBody
    @GetMapping ("/dvds/{id}")
    public DvdEntry retrieveDvdEntryById (@PathVariable ("id") Integer id) {
        return this.dvdService.findDvdEntryById(id);
    }

    @ResponseBody
    @PostMapping ("/dvds")
    public void addDvd (@RequestBody DvdEntry dvdEntry) {
        this.dvdService.save(dvdEntry);
    }

    @PostMapping ("/dvds/create")
    public String createDvd (@ModelAttribute(value="newEntry") DvdEntry dvdEntry) {
        this.dvdService.save(dvdEntry);
        return HOMEPAGE_REDIRECT;
    }

    @ResponseBody
    @DeleteMapping ("dvds/{id}")
    public void deleteDvdEntryById (@PathVariable ("id") Integer id) {
        this.dvdService.deleteDvdEntryById(id);
    }

    @GetMapping ("/dvds/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {
        this.dvdService.deleteDvdEntryById (id);
        return HOMEPAGE_REDIRECT;
    }
}
