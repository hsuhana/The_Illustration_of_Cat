package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

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

    public static ArrayList<Cat> catLists;

    @FXML
    private ArrayList<Cat> searchForCats(ActionEvent event) throws IOException, InterruptedException {
        String origin = searchTextField.getText().trim();

        SimpleApiHttpClient test = new SimpleApiHttpClient();

        catLists = test.parseJsonPosts(test.fetchData("https://api.thecatapi.com/v1/breeds"));

        List<String> catNames = catLists.stream().filter(cat -> cat.getOrigin().equalsIgnoreCase(origin)).map(Cat::getName).collect(Collectors.toList());

        listView.getItems().clear();
        listView.getItems().addAll(catNames);

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

}
