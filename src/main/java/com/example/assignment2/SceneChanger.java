package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScenes(ActionEvent event, String fxmlFileName, String catId, Cat selectedCat) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //get the Controller for the destination view and call the "loadMovie()" method
        CatLoader controller = fxmlLoader.getController();
        controller.loadCat(catId, selectedCat);

        //get the Stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Image icon = new Image("https://cdn4.iconfinder.com/data/icons/animals-57/500/cat_animal_-1024.png");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //get the Controller for the destination view and call the "loadMovie()" method
//        CatLoader controller = fxmlLoader.getController();
//        controller.loadCat(catSelected);

        //get the Stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public static void addScenes(ActionEvent event, double width, double height, Image url) throws IOException{

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("randomCatImage.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        RandomCatImageController controller = loader.getController();
        controller.loadRandomCat(url);

        Scene scene = new Scene(root);
        newStage.setTitle("GIVE ME A CAT");
        newStage.setScene(scene);
        newStage.setWidth(width);
        newStage.setHeight(height);
        newStage.show();

        //        FXMLLoader loader = new FXMLLoader(getClass().getResource("randomCatImage.fxml"));
//        Parent root = loader.load();
//
//        Stage newStage = new Stage();
//        RandomCatImageController controller = loader.getController(); // Get the controller
//        controller.setStage(newStage); // Pass the stage to the controller
//        controller.initialize(); // Initialize the controller
//
//        Scene scene = new Scene(root);
//        newStage.setTitle("GIVE ME A CAT");
//        newStage.setScene(scene);
//        newStage.show();
    }
}
