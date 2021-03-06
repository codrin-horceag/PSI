package com.proiectmvc.demo.controller;

import java.util.List;
import java.util.Optional;

import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.depozit.DepozitRepository;
import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.document.NotaPredareRepository;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import com.proiectmvc.demo.produsfinit.ProdusFinitRepository;


@org.springframework.stereotype.Controller
public class Controller {

    private final NotaPredareRepository notaPredareRepository;
    private final DepozitRepository depozitRepository;
    private final  ProdusFinitRepository produsFinitRepository;

    public Controller(
            NotaPredareRepository notaPredareRepository,
            DepozitRepository depozitRepository,
            ProdusFinitRepository produsFinitRepository
    ) {
        this.notaPredareRepository = notaPredareRepository;
        this.depozitRepository = depozitRepository;
        this.produsFinitRepository = produsFinitRepository;
    }

    public void createNotaPredare(NotaPredare notaPredare) {
        notaPredareRepository.save(notaPredare);
    }

    //
    public List<ProdusFinit> getAllProduseFinite() {
        return produsFinitRepository.findAll();
    }

    public ProdusFinit getProdusFinitById(Long id) {
        Optional<ProdusFinit> prodFinit = produsFinitRepository.findById(id);
        return prodFinit.get();
    }

    public void pushProdusFinit(List<ProdusFinit> prodFin, Depozit depozit, NotaPredare newNotaPredare) {
        depozit.getProduseFinite().addAll(prodFin);
        depozitRepository.save(depozit);
    }

    public Depozit getDepozitById(Long id) {
        Optional<Depozit> depozit = depozitRepository.findById(id);
        return depozit.get();
    }

    public List<Depozit> getAllDepozite(){
        return depozitRepository.findAll();
    }
}
