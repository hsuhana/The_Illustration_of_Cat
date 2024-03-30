package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class detailSceneController implements CatLoader {

    @FXML
    private Label nameLabel;

    @FXML
    private Label temperamentLabel;

    @FXML
    private Label originLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private ImageView imageView;

    @FXML
    void backToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "searchScene.fxml");
    }

    public void loadCat(String catId, Cat selectedCat){

            SimpleApiHttpClient test = new SimpleApiHttpClient();
            //CatImage image = test.parseJsonImagePosts(test.fetchCatImage(catId));
            ArrayList<CatImage> image = test.parseJsonImagePosts(test.fetchCatImage(catId));

            nameLabel.setText(selectedCat.getName());
            temperamentLabel.setText(selectedCat.getTemperament());
            originLabel.setText(selectedCat.getOrigin());
            descriptionLabel.setText(selectedCat.getDescription());
            descriptionLabel.setWrapText(true);
            imageView.setImage(new Image(image.get(0).getUrl()));
    }
}
