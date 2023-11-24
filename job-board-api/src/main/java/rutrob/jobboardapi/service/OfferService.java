package rutrob.jobboardapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rutrob.jobboardapi.entity.Offer;
import rutrob.jobboardapi.repository.OfferRepository;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }
}
