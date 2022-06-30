package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/{id}")
    public Optional<Whisky> getWhisky(@PathVariable Long id){
        return whiskyRepository.findById(id);
    }

    @PostMapping(value = "/whisky")
    public ResponseEntity<Whisky> postPirate(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

//    @GetMapping(name="/whisky/year")
//    public ResponseEntity<List<Whisky>> findWhiskyByYear(
//            @RequestParam(name="year") int year)
//    {
//        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
//    }


    @GetMapping(name="/whisky/distillery-and-age")
    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryAndAge(
            @RequestParam(name="distillery")Distillery distillery, @RequestParam(name="year") int age)
    {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryAndAge(distillery, age), HttpStatus.OK);
    }
}








