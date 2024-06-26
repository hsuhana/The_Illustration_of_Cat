package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class searchSceneController {

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button getDetailButton;

    public static ArrayList<Cat> catLists;

    public static List<String> catUniqueOrigin;

    @FXML
    private void initialize(){

        listView.getItems().clear();
        listView.getItems().add("Search Instruction:");
        listView.getItems().add("Please type one of the countries below in search bar.");
        listView.getItems().add("And press search button to check the result.");

        SimpleApiHttpClient test = new SimpleApiHttpClient();

        catLists = test.parseJsonPosts(test.fetchData("https://api.thecatapi.com/v1/breeds"));
        catUniqueOrigin = catLists.stream().map(Cat::getOrigin).distinct().collect(Collectors.toList());
        listView.getItems().addAll(catUniqueOrigin);

        getDetailButton.setVisible(false);
    }

    @FXML
    private ArrayList<Cat> searchForCats(ActionEvent event) throws IOException, InterruptedException {
        String origin = searchTextField.getText().trim();

        SimpleApiHttpClient test = new SimpleApiHttpClient();

        catLists = test.parseJsonPosts(test.fetchData("https://api.thecatapi.com/v1/breeds"));

        List<String> catNames = catLists.stream().filter(cat -> cat.getOrigin().equalsIgnoreCase(origin)).map(Cat::getName).collect(Collectors.toList());

        if(catNames.size() > 0){
            listView.getItems().clear();
            listView.getItems().addAll(catNames);

            getDetailButton.setVisible(true);
        }else{
            listView.getItems().clear();
            listView.getItems().add("Sorry, no cats' origin from this country :(");
            listView.getItems().add("Try those countries as listed below.");
            listView.getItems().addAll(catUniqueOrigin);

            getDetailButton.setVisible(false);
        }

        return catLists;
    }

    @FXML
    public void getCatDetails(ActionEvent event) throws IOException {
        String catSelected = listView.getSelectionModel().getSelectedItem();
        Optional<Cat> catOptional = catLists.stream().filter(cat -> cat.getName().equalsIgnoreCase(catSelected)).findFirst();
        String catId = catOptional.map(Cat::getId).orElse(null);
        Cat selectedCat = catOptional.get();
        SceneChanger.changeScenes(event, "detailScene.fxml", catId, selectedCat);
    }

    @FXML
    public void randomCatImage(ActionEvent event) throws IOException {
        SimpleApiHttpClient test = new SimpleApiHttpClient();
        //CatImage image = test.parseJsonImagePosts(test.fetchCatImage(catId));
        ArrayList<CatImage> image = test.parseJsonImagePosts(test.fetchRandomCatImage());

        CatImage catImage = image.get(0);
        Image images = new Image(catImage.getUrl());
        double width = images.getWidth()-50;
        double height = images.getHeight()-50;
        //stage.setWidth(width);
        //stage.setHeight(height);

        SceneChanger.addScenes(event, width, height, images);

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
