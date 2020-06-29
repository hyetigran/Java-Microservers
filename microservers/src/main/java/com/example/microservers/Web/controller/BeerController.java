package com.example.microservers.Web.controller;

import com.example.microservers.Web.model.BeerDto;
import com.example.microservers.services.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerid}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerid") UUID beerid){
        return new ResponseEntity<>(beerService.getBeerById(beerid), HttpStatus.OK);

    }
}
