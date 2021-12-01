package com.example.demo.controller;

import com.example.demo.model.Child;
import com.example.demo.model.Mom;
import com.example.demo.service.ChildService;
import com.example.demo.service.MomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    private final ChildService childService;
    private final MomService momService;

    @Autowired
    public HomeController(ChildService childService, MomService momService) {
        this.childService = childService;
        this.momService = momService;
    }

    @GetMapping(path = "child/all")
    public List<Child> getChildren() {
        return childService.getChildren();
    }

    @GetMapping(path = "mom/all")
    public List<Mom> getMommies() {
        return momService.getMommies();
    }

    @DeleteMapping(path = "mom/delete/{id}")
    public String deleteMom(@PathVariable("id") Long id) {
        momService.deleteMomById(id);
        return "MOMMY WAS REMOVED SUCCESSFULLY";
    }

    @DeleteMapping(path = "child/delete/{id}")
    public String deleteChild(@PathVariable("id") Long id) {
        childService.deleteChildById(id);
        return "CHILD WAS REMOVED SUCCESSFULLY";
    }
}
