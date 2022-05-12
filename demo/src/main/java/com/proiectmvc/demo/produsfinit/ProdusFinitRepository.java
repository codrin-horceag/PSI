package com.proiectmvc.demo.produsfinit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ProdusFinit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdusFinitRepository extends JpaRepository<ProdusFinit, Long> {}
