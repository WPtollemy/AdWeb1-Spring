package com.willpiears.assignment1spring.controller;

import com.willpiears.assignment1spring.domain.DvdEntry;
import com.willpiears.assignment1spring.service.DvdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DvdsController
{
    @Autowired
    private DvdService dvdService;

    //Templates and redirects
    private static final String DVD_TEMPLATE = "dvds";
    private static final String EDIT_TEMPLATE = "editDvds";
    private static final String LOGIN_TEMPLATE = "login";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    //Web Mappings
    @GetMapping ("/")
    public String displayDvds (Model model) {
        model.addAttribute ("entries", this.dvdService.findAllEntries());
        model.addAttribute ("newEntry", new DvdEntry());

        return DVD_TEMPLATE;
    }

    @GetMapping ("/login")
    public String displayLogin () {
        return LOGIN_TEMPLATE;
    }

    @PostMapping ("/dvds/create")
    public String createDvd (@ModelAttribute(value="newEntry") DvdEntry dvdEntry) {
        this.dvdService.save(dvdEntry);
        return HOMEPAGE_REDIRECT;
    }

    @GetMapping ("/dvds/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {
        this.dvdService.deleteDvdEntryById (id);
        return HOMEPAGE_REDIRECT;
    }

    @GetMapping ("/dvds/edit/{id}")
    public String displayEditDvds (@PathVariable Integer id, Model model) {
        model.addAttribute ("entry", this.dvdService.findDvdEntryById(id));
        model.addAttribute ("newEntry", new DvdEntry());

        return EDIT_TEMPLATE;
    }

    @PostMapping ("/dvds/update/{id}")
    public String saveUpdatedDvd (
            @PathVariable Integer id,
            @ModelAttribute(value="newEntry") DvdEntry dvdEntry
            ) {
        this.dvdService.save(dvdEntry);
        return HOMEPAGE_REDIRECT;
    }

    @GetMapping ("/dvds/search")
    public String retrieveMatchingDvds (@RequestParam (name = "searchTitle") String title, Model model) {
        //When nothing is searched for return all DVDs
        if (title.equals("")) {
            return HOMEPAGE_REDIRECT;
        }

        model.addAttribute ("entries", this.dvdService.findByTitleContaining(title));
        model.addAttribute ("newEntry", new DvdEntry());

        return DVD_TEMPLATE;
    }

    //API Mappings
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

    @ResponseBody
    @DeleteMapping ("dvds/{id}")
    public void deleteDvdEntryById (@PathVariable ("id") Integer id) {
        this.dvdService.deleteDvdEntryById(id);
    }

    @ResponseBody
    @PatchMapping ("/dvds")
    public void updateDvd (@RequestBody DvdEntry dvdEntry) {
        this.dvdService.save(dvdEntry);
    }
}
