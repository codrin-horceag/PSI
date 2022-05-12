package com.proiectmvc.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static javafx.application.Application.launch;

@SpringBootApplication
public class ProiectPsiApplication extends Application {

	public static void main(String[] args) {
		SpringApplication.run(ProiectPsiApplication.class, args);
		launch();
	}

	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(ProiectPsiApplication.class.getResource("notapredare.fmxl"));
		stage.setTitle("Nota predare");
		stage.setScene(new Scene(root));
		stage.show();
	}
}
