package com.proiectmvc.demo.view;

import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class View {
    private final Controller controller;
//    @FXML
//    private Button btnAdauga;
//
//    @FXML
//    private Button btnSalveaza;
//
//    @FXML
//    private TableColumn<ProdusFinit, Double> cantitate;
//
//    @FXML
//    private TableColumn<ProdusFinit, Double> cantitate1;
//
//    @FXML
//    private ComboBox<Depozit> cmbDepozite;
//
//    @FXML
//    private TableColumn<ProdusFinit, Long> codProdus;
//
//    @FXML
//    private TableColumn<ProdusFinit, Long> codProdus1;
//
//    @FXML
//    private TableColumn<ProdusFinit, String> denumireProdus;
//
//    @FXML
//    private TableColumn<ProdusFinit, String> denumireProdus1;
//
//    @FXML
//    private DatePicker dtpDataEliberare;
//
//    @FXML
//    private DatePicker dtpDataIntocmire;
//
//    @FXML
//    private Label lblCodDocument;
//
//    @FXML
//    private Label lblDataEliberare;
//
//    @FXML
//    private Label lblDataIntocmire;
//
//    @FXML
//    private Label lblNotaPredare;
//
//    @FXML
//    private Label lblProdDisponibile;
//
//    @FXML
//    private Label lblProdSelectate;
//
//    @FXML
//    private Label lblSelectatiDepozitul;
//
//    @FXML
//    private Label lblSelectatiProdusele;
//
//    @FXML
//    private TableView<ProdusFinit> prodDisponibile;
//
//    @FXML
//    private TableView<ProdusFinit> prodSelectate;
//
//    @FXML
//    private TextField txtCodDocument;
//
//    @FXML
//    private TableColumn<ProdusFinit,String> um;
//
//    @FXML
//    private TableColumn<ProdusFinit,String> um1;
//
//
//    @FXML
//    void salvare(ActionEvent event) {
//        //transferProdus();
//    }


    public View(Controller controller) {
        this.controller = controller;
    }

    public ProdusFinit getProdusFinitById(Long id) {
        return controller.getProdusFinitById(id);
    }

    public List<ProdusFinit> getAllProduseFinite() {
        return controller.getAllProduseFinite();
    }

    public Depozit getDepozitById(Long id) {
        return controller.getDepozitById(id);
    }


    public void transferProdus(List<ProdusFinit> produseFinite, Depozit depozit, NotaPredare notaPredare) {
        controller.createNotaPredare(notaPredare);
        controller.pushProdusFinit(produseFinite, depozit, notaPredare);
    }

    public List<Depozit> getAllDepozite(){
        return controller.getAllDepozite();
    }


    /*public void initialize(URL url, ResourceBundle resourceBundle) {
        denumireProdus.setCellValueFactory(new PropertyValueFactory<ProdusFinit,String>("denumireProdus"));
        codProdus.setCellValueFactory(new PropertyValueFactory<ProdusFinit,Long>("codProdus"));
        cantitate.setCellValueFactory(new PropertyValueFactory<ProdusFinit, Double>("cantitate"));
        um.setCellValueFactory(new PropertyValueFactory<ProdusFinit,String>("um"));

        prodDisponibile.setItems(produseFinite);
    }*/
//    ObservableList<ProdusFinit> produseFinite = FXCollections.observableArrayList(
//            new ProdusFinit(1,"inghetata cu vanilie", 2.0,"cutii"),
//            new ProdusFinit(2,"inghetata cu ciocolata", 3.0, "baxuri"),
//            new ProdusFinit(3,"inghetata cu caramel", 4.0,"cutii")
//    );
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        denumireProdus.setCellValueFactory(new PropertyValueFactory<ProdusFinit,String>("denumireProdus"));
//        codProdus.setCellValueFactory(new PropertyValueFactory<ProdusFinit,Long>("codProdus"));
//        cantitate.setCellValueFactory(new PropertyValueFactory<ProdusFinit, Double>("cantitate"));
//        um.setCellValueFactory(new PropertyValueFactory<ProdusFinit,String>("um"));
//        ObservableList<ProdusFinit> produseDisponibile = FXCollections.observableArrayList();
//        produseDisponibile.addAll(getAllProduseFinite());
//        prodDisponibile.setItems(produseDisponibile);
//    }
}
