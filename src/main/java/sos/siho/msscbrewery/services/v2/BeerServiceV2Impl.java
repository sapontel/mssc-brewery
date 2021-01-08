package sos.siho.msscbrewery.services.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sos.siho.msscbrewery.web.model.BeerDto;
import sos.siho.msscbrewery.web.model.v2.BeerDtoV2;
import sos.siho.msscbrewery.web.model.v2.BeerStyleEnum;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return new BeerDtoV2().builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();

    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return new BeerDtoV2().builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Update a customer.....");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Delete a customer.....");
    }
}
