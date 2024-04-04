package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("searchScene.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        Parent root = FXMLLoader.load(getClass().getResource("searchScene.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("https://cdn4.iconfinder.com/data/icons/animals-57/500/cat_animal_-1024.png");

        stage.getIcons().add(icon);
        stage.setTitle("Cats");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


//        SimpleApiHttpClient test = new SimpleApiHttpClient();
//
//        for (Cat cat : (test.parseJsonPosts(test.fetchData("https://api.thecatapi.com/v1/breeds")))) {
//            System.out.println(cat.toString());
//        }

        launch();
    }
}