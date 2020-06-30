package com.example.microservers.services.v2;

import com.example.microservers.Web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {


    BeerDtoV2 getBeerById(UUID beerid);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerid, BeerDtoV2 beerDto);

    void deleteById(UUID beerid);
}
