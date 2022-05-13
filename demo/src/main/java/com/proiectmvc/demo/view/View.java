package com.proiectmvc.demo.view;

import com.proiectmvc.demo.ProiectPsiApplication;
import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.naming.ldap.Control;
import java.awt.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.List;

public class View {
    private final Controller controller;
    @FXML
    private Button btnSalveaza;

    @FXML
    private TableColumn<ProdusFinit, Double> cantitate;

    @FXML
    private ComboBox<Depozit> cmbDepozite;

    @FXML
    private TableColumn<ProdusFinit, Long> codProdus;

    @FXML
    private TableColumn<ProdusFinit, String> denumireProdus;

    @FXML
    private DatePicker dtpDataEliberare;

    @FXML
    private DatePicker dtpDataIntocmire;

    @FXML
    private Label lblCodDocument;

    @FXML
    private Label lblDataEliberare;

    @FXML
    private Label lblDataIntocmire;

    @FXML
    private Label lblNotaPredare;

    @FXML
    private Label lblSelectatiDepozitul;

    @FXML
    private Label lblSelectatiProdusele;

    @FXML
    private TableView<ProdusFinit> tabel;

    @FXML
    private TextField txtCodDocument;

    @FXML
    private TableColumn<ProdusFinit, String> um;

    @FXML
    void salvare(ActionEvent event) {

    }

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

    public void transferProdus(ProdusFinit produsFinit, Depozit depozit, NotaPredare notaPredare) {
        controller.pushProdusFinit(produsFinit, depozit, notaPredare);
    }

 //   public void initialize {

   // }




}
