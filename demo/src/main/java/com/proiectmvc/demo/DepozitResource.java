package com.proiectmvc.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.depozit.DepozitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional
public class DepozitResource {

    private final Logger log = LoggerFactory.getLogger(DepozitResource.class);

    private static final String ENTITY_NAME = "depozit";

    private final DepozitRepository depozitRepository;

    public DepozitResource(DepozitRepository depozitRepository) {
        this.depozitRepository = depozitRepository;
    }

    @PostMapping("/depozits")
    public void createDepozit(@RequestBody Depozit depozit) throws URISyntaxException {
        Depozit result = depozitRepository.save(depozit);
    }

    /**
     * {@code PUT  /depozits/:id} : Updates an existing depozit.
     *
     * @param id the id of the depozit to save.
     * @param depozit the depozit to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated depozit,
     * or with status {@code 400 (Bad Request)} if the depozit is not valid,
     * or with status {@code 500 (Internal Server Error)} if the depozit couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    public void updateDepozit(@PathVariable(value = "id", required = false) final Long id, @RequestBody Depozit depozit)
        throws URISyntaxException {
        log.debug("REST request to update Depozit : {}, {}", id, depozit);
        Depozit result = depozitRepository.save(depozit);
    }

    public void partialUpdateDepozit(Depozit depozit) {

        Optional<Depozit> result = depozitRepository
            .findById(depozit.getId())
            .map(existingDepozit -> {
                if (depozit.getDenumireDepozit() != null) {
                    existingDepozit.setDenumireDepozit(depozit.getDenumireDepozit());
                }
                if (depozit.getMaterialDepozit() != null) {
                    existingDepozit.setMaterialDepozit(depozit.getMaterialDepozit());
                }

                return existingDepozit;
            })
            .map(depozitRepository::save);
    }

    /**
     * {@code GET  /depozits} : get all the depozits.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of depozits in body.
     */
    public List<Depozit> getAllDepozits() {
        log.debug("REST request to get all Depozits");
        return depozitRepository.findAll();
    }

    /**
     * {@code GET  /depozits/:id} : get the "id" depozit.
     *
     * @param id the id of the depozit to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the depozit, or with status {@code 404 (Not Found)}.
     */
    public void getDepozit(@PathVariable Long id) {
        log.debug("REST request to get Depozit : {}", id);
        Optional<Depozit> depozit = depozitRepository.findById(id);
    }

    /**
     * {@code DELETE  /depozits/:id} : delete the "id" depozit.
     *
     * @param id the id of the depozit to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    public void deleteDepozit(@PathVariable Long id) {
        log.debug("REST request to delete Depozit : {}", id);
        depozitRepository.deleteById(id);
    }
}
