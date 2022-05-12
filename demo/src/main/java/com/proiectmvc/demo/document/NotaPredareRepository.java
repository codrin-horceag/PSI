package com.proiectmvc.demo.document;

import com.proiectmvc.demo.document.NotaPredare;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the NotaPredare entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotaPredareRepository extends JpaRepository<NotaPredare, Long> {}
