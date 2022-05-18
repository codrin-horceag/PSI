package com.proiectmvc.demo;

import com.proiectmvc.demo.controller.Controller;
import com.proiectmvc.demo.depozit.DepozitRepository;
import com.proiectmvc.demo.document.DocumentRepository;
import com.proiectmvc.demo.document.NotaPredareRepository;
import com.proiectmvc.demo.produsfinit.ProdusFinitRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import static javafx.application.Application.launch;
import com.proiectmvc.demo.view.View;
import com.proiectmvc.demo.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProiectPsiApplication {


	public static void main(String[] args) {
//		launch();
		SpringApplication.run(ProiectPsiApplication.class, args);
	}


//	public void start(Stage stage) throws IOException {
////		FXMLLoader fxmlLoader = new FXMLLoader(ProiectPsiApplication.class.getResource("/notapredare.fxml"));
////		fxmlLoader.setRoot(new AnchorPane());
//		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/notapredare.fxml"));
//		Scene scene = new Scene(root);
//		stage.setTitle("Nota Predare");
//		stage.setScene(scene);
//		stage.show();
//	}


}
