package com.example.microservers.Web.controller;

import com.example.microservers.Web.model.BeerDto;
import com.example.microservers.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
        BeerDto saveDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerid}"})
    public ResponseEntity handleUpdate(@PathVariable("beerid") UUID beerid, @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerid, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerid}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerid") UUID beerid){
        beerService.deleteById(beerid);
    }
}
