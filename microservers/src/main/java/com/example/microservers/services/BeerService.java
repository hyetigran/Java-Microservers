package com.example.microservers.services;

import com.example.microservers.Web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerid);
}
