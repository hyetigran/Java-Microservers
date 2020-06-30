package com.tigran.beer.web.controller;

import com.tigran.beer.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerid") UUID beerid){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerid}")
    public ResponseEntity<BeerDto> saveNewBeer(@PathVariable("beerid") UUID beerid, @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
