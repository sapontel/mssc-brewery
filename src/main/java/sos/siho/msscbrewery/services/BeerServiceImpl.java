package sos.siho.msscbrewery.services;

import org.springframework.stereotype.Service;
import sos.siho.msscbrewery.web.model.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return new BeerDto().builder().id(beerId)
                .beerName("Galaxy Cat")
                .styleBeer("Pale Ale")
                .build();
    }
}
