package com.proiectmvc.demo;

import com.proiectmvc.demo.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.proiectmvc.demo.view.View;

import java.io.IOException;

import static javafx.application.Application.launch;

@SpringBootApplication
public class ProiectPsiApplication extends Application{


	public static void main(String[] args) {
		launch();
		SpringApplication.run(ProiectPsiApplication.class, args);




	}


	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(ProiectPsiApplication.class.getResource("notapredare.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Nota Predare");
		stage.setScene(scene);
		stage.show();
	}


}
