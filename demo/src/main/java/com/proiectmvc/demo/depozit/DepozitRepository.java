package com.proiectmvc.demo.depozit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Depozit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DepozitRepository extends JpaRepository<Depozit, Long> {}
