package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/years/{year}")
    public List<Whisky> findWhiskyByYear(@PathVariable int year) {
        return whiskyRepository.findWhiskeyByYear(year);
    }

    @GetMapping(value = "/distillery/{name}/{age}")
    public List<Whisky> findSpecificWhiskyFromSpecificDistillery(@PathVariable String name, Integer age) {
        return whiskyRepository.findSpecificWhiskyFromSpecificDistillery(name, age);
    }

    @GetMapping(value = "/distillery/{region}")
    public List<Whisky> findEveryWhiskyInSpecificRegion(@PathVariable String region) {
        return whiskyRepository.findEveryWhiskyInSpecificRegion(region);
    }
}
