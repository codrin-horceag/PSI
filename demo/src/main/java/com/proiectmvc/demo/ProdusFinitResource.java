//package com.proiectmvc.demo;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//import com.proiectmvc.demo.produsfinit.ProdusFinitRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
///**
// * REST controller for managing {@link y.domain.ProdusFinit}.
// */
//@RestController
//@RequestMapping("/api")
//@Transactional
//public class ProdusFinitResource {
//
//    private final Logger log = LoggerFactory.getLogger(ProdusFinitResource.class);
//
//    private static final String ENTITY_NAME = "produsFinit";
//
//    @Value("${jhipster.clientApp.name}")
//    private String applicationName;
//
//    private final ProdusFinitRepository produsFinitRepository;
//
//    public ProdusFinitResource(ProdusFinitRepository produsFinitRepository) {
//        this.produsFinitRepository = produsFinitRepository;
//    }
//
//    /**
//     * {@code POST  /produs-finits} : Create a new produsFinit.
//     *
//     * @param produsFinit the produsFinit to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new produsFinit, or with status {@code 400 (Bad Request)} if the produsFinit has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/produs-finits")
//    public ResponseEntity<ProdusFinit> createProdusFinit(@RequestBody ProdusFinit produsFinit) throws URISyntaxException {
//        log.debug("REST request to save ProdusFinit : {}", produsFinit);
//        if (produsFinit.getId() != null) {
//            throw new BadRequestAlertException("A new produsFinit cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ProdusFinit result = produsFinitRepository.save(produsFinit);
//        return ResponseEntity
//            .created(new URI("/api/produs-finits/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /produs-finits/:id} : Updates an existing produsFinit.
//     *
//     * @param id the id of the produsFinit to save.
//     * @param produsFinit the produsFinit to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated produsFinit,
//     * or with status {@code 400 (Bad Request)} if the produsFinit is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the produsFinit couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/produs-finits/{id}")
//    public ResponseEntity<ProdusFinit> updateProdusFinit(
//        @PathVariable(value = "id", required = false) final Long id,
//        @RequestBody ProdusFinit produsFinit
//    ) throws URISyntaxException {
//        log.debug("REST request to update ProdusFinit : {}, {}", id, produsFinit);
//        if (produsFinit.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, produsFinit.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        if (!produsFinitRepository.existsById(id)) {
//            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
//        }
//
//        ProdusFinit result = produsFinitRepository.save(produsFinit);
//        return ResponseEntity
//            .ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, produsFinit.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PATCH  /produs-finits/:id} : Partial updates given fields of an existing produsFinit, field will ignore if it is null
//     *
//     * @param id the id of the produsFinit to save.
//     * @param produsFinit the produsFinit to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated produsFinit,
//     * or with status {@code 400 (Bad Request)} if the produsFinit is not valid,
//     * or with status {@code 404 (Not Found)} if the produsFinit is not found,
//     * or with status {@code 500 (Internal Server Error)} if the produsFinit couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PatchMapping(value = "/produs-finits/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public ResponseEntity<ProdusFinit> partialUpdateProdusFinit(
//        @PathVariable(value = "id", required = false) final Long id,
//        @RequestBody ProdusFinit produsFinit
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update ProdusFinit partially : {}, {}", id, produsFinit);
//        if (produsFinit.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, produsFinit.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        if (!produsFinitRepository.existsById(id)) {
//            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
//        }
//
//        Optional<ProdusFinit> result = produsFinitRepository
//            .findById(produsFinit.getId())
//            .map(existingProdusFinit -> {
//                if (produsFinit.getCantitate() != null) {
//                    existingProdusFinit.setCantitate(produsFinit.getCantitate());
//                }
//                if (produsFinit.getDenumire() != null) {
//                    existingProdusFinit.setDenumire(produsFinit.getDenumire());
//                }
//                if (produsFinit.getUnitateMasura() != null) {
//                    existingProdusFinit.setUnitateMasura(produsFinit.getUnitateMasura());
//                }
//
//                return existingProdusFinit;
//            })
//            .map(produsFinitRepository::save);
//
//        return ResponseUtil.wrapOrNotFound(
//            result,
//            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, produsFinit.getId().toString())
//        );
//    }
//
//    /**
//     * {@code GET  /produs-finits} : get all the produsFinits.
//     *
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of produsFinits in body.
//     */
//    @GetMapping("/produs-finits")
//    public List<ProdusFinit> getAllProdusFinits() {
//        log.debug("REST request to get all ProdusFinits");
//        return produsFinitRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /produs-finits/:id} : get the "id" produsFinit.
//     *
//     * @param id the id of the produsFinit to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the produsFinit, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/produs-finits/{id}")
//    public ResponseEntity<ProdusFinit> getProdusFinit(@PathVariable Long id) {
//        log.debug("REST request to get ProdusFinit : {}", id);
//        Optional<ProdusFinit> produsFinit = produsFinitRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(produsFinit);
//    }
//
//    /**
//     * {@code DELETE  /produs-finits/:id} : delete the "id" produsFinit.
//     *
//     * @param id the id of the produsFinit to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/produs-finits/{id}")
//    public ResponseEntity<Void> deleteProdusFinit(@PathVariable Long id) {
//        log.debug("REST request to delete ProdusFinit : {}", id);
//        produsFinitRepository.deleteById(id);
//        return ResponseEntity
//            .noContent()
//            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//            .build();
//    }
//}
