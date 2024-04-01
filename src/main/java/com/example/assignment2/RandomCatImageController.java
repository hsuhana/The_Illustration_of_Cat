package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RandomCatImageController implements RandomCatLoader {

    @FXML
    private ImageView imageView;


//    public void initialize() {
//        // Call the method to load cat image when the controller is initialized
//        loadRandomCat();
//    }

    public void loadRandomCat(Image url){

        imageView.setImage(url);
//        SimpleApiHttpClient test = new SimpleApiHttpClient();
//        //CatImage image = test.parseJsonImagePosts(test.fetchCatImage(catId));
//        ArrayList<CatImage> image = test.parseJsonImagePosts(test.fetchRandomCatImage());
//
//        CatImage catImage = image.get(0);
//        Image images = new Image(catImage.getUrl());
//        imageView.setImage(images);
//
//        double width = images.getWidth();
//        double height = images.getHeight();
//        stage.setWidth(width);
//        stage.setHeight(height);
    }
}
