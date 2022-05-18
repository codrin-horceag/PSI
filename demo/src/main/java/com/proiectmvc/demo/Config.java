package com.proiectmvc.demo;

import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.depozit.DepozitRepository;
import com.proiectmvc.demo.depozit.StocDepozit;
import com.proiectmvc.demo.document.Document;
import com.proiectmvc.demo.document.DocumentRepository;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import com.proiectmvc.demo.produsfinit.ProdusFinitRepository;
import com.proiectmvc.demo.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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
            System.out.println(depozit1.getProduseFinite().addAll(produse));

            depozitRepository.save(depozit1);

            //adaugare documente

            Document document1 = new Document( LocalDate.now(), LocalDate.of(2021, 06, 19), 1);
            documentRepository.save(document1);

            //test depozite

            System.out.println("DEPOZITE \n" +
                    "=================================================== \n");
            List<Depozit> depozite = view.getAllDepozite();
            for (Depozit d : depozite){
                System.out.println("id: " + d.getId() + "\n"
                        + "denumire: " + d.getDenumireDepozit() + "\n"
                        + "tip material: " + d.getMaterialDepozit() +"\n"
                        + "produsele depozitului:");
                for (ProdusFinit p : d.getProduseFinite()){
                    System.out.println("id produs: " + p.getId() + "\n"
                        + "denumire produs: " + p.getDenumire() + "\n"
                        + "cantitate: " + p.getCantitate() + "\n"
                        + "unitate masura" + p.getUnitateMasura());
                }
            }
        };
    }
}
