package rutrob.jobboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rutrob.jobboardapi.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
