package com.proiectmvc.demo.view;

import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.produsfinit.ProdusFinit;

import javax.naming.ldap.Control;
import java.util.List;

public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public List<ProdusFinit> getAllProduseFinite() {
        return controller.getAllProduseFinite();
    }

    public Depozit getDepozitById(Long id) {
        return controller.getDepozitById(id);
    }

    public void createNotaPredare(NotaPredare notaPredare) {
        controller.createNotaPredare(notaPredare);
    }

    public void transferProdus(ProdusFinit produsFinit, Depozit depozit) {
        controller.pushProdusFinit(produsFinit, depozit);
    }

 //   public void initialize {

   // }
}
