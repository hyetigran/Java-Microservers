package com.tigran.beer.bootstrap;

import com.tigran.beer.domain.Beer;
import com.tigran.beer.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                .beername("Mango")
                .beerstyle("IPA")
                .quantitytobrew(200)
                .minonhand(12)
                .upc(1111111111L)
                .price(new BigDecimal("12.95"))
                .build());

            beerRepository.save(Beer.builder()
                .beername("Galaxy Cat")
                .beerstyle("PALE_ALE")
                .quantitytobrew(200)
                .minonhand(12)
                .upc(2111111111L)
                .price(new BigDecimal("10.95"))
                .build());
        }

        //System.out.println("Loaded Bers: " + beerRepository.count());
    }
}
