package com.proiectmvc.demo;

import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.depozit.DepozitRepository;
import com.proiectmvc.demo.depozit.StocDepozit;
import com.proiectmvc.demo.document.Document;
import com.proiectmvc.demo.document.DocumentRepository;
import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import com.proiectmvc.demo.produsfinit.ProdusFinitRepository;
import com.proiectmvc.demo.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(
            DepozitRepository depozitRepository,
            DocumentRepository documentRepository,
            ProdusFinitRepository produsFinitRepository,
            View view
    ){
        return args -> {

            //adaugare produse finite

            ProdusFinit produs1 = new ProdusFinit(1, 200.0, "Inghetata cu vanilie", "KG");
            ProdusFinit produs2 = new ProdusFinit(2, 300.0, "Inghetata cu cacao", "KG");
            ProdusFinit produs3 = new ProdusFinit(3, 400.0, "Inghetata cu fistic", "KG");
            List<ProdusFinit> produse = new LinkedList<ProdusFinit>();
            produse.add(produs1);
            produse.add(produs2);
            produse.add(produs3);

            produsFinitRepository.saveAll((produse));

            //adaugare depozit

            Depozit depozit1 = new Depozit(1L, "Depozit 1", StocDepozit.CIOCOLATA, new LinkedList<>());

            depozitRepository.save(depozit1);

            //adaugare documente

            Document document1 = new Document( LocalDate.now(), LocalDate.of(2021, 06, 19), 1);
            documentRepository.save(document1);

            //preluare depozite

            System.out.println("DEPOZITE \n" +
                    "===================================================");
            List<Depozit> depozite = view.getAllDepozite();
            for (Depozit d : depozite){
                System.out.println("id: " + d.getId() + "\n"
                        + "denumire: " + d.getDenumireDepozit() + "\n"
                        + "tip material: " + d.getMaterialDepozit() +"\n");
            }

            System.out.println("====================================================");

            //preluare produse finite
            System.out.println("PRODUSE FINITE \n"+
                    "====================================================");

            List<ProdusFinit> produseFinite = view.getAllProduseFinite();
            for (ProdusFinit p : produseFinite){
                System.out.println("id: " + p.getId() + "\n"
                        + "denumire: " + p.getDenumire() + "\n"
                        + "cantitate: " + p.getCantitate() +"\n"
                        + "unitate masura: " + p.getUnitateMasura());
            }

            System.out.println("====================================================");
            System.out.println("Test functionalitate formular");
            System.out.println("====================================================");
            System.out.println();
            //selectare depozit pentru nota predare, dupa id
            Depozit depozitDeSelectat = view.getDepozitById(1L);

            //selectare produse de adaugat in nota predare, dupa id
            ProdusFinit produsFinitDeSelectat1 = view.getProdusFinitById(1L);
            ProdusFinit produsFinitDeSelectat2 = view.getProdusFinitById(2L);
            List<ProdusFinit> listaProduse = List.of(produsFinitDeSelectat1, produsFinitDeSelectat2);

            //creare nota predare dupa datele scrise in formular
            NotaPredare newNotaPredare = new NotaPredare(LocalDate.now(), LocalDate.now(), 1, listaProduse, depozitDeSelectat);
            //in final, efectuarea transferului produselor finite selectate in depozitul selectat
            //in acest proces, se apeleaza controller-ul pentru a crea o nota de predare
            view.transferProdus(listaProduse, depozitDeSelectat, newNotaPredare);
            System.out.println("S-au adaugat la depozitul " + depozitDeSelectat.getId() + " urmatoarele produse finite: ");
            for (ProdusFinit p : listaProduse) {
                System.out.println("id: " + p.getId() + "\n"
                    + "denumire: " + p.getDenumire() + "\n"
                    + "cantitate " + p.getCantitate() + "\n"
                    + "unitate masura: " + p.getUnitateMasura());
            }
        };
    }
}
