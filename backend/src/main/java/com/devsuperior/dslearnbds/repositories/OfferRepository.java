package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
