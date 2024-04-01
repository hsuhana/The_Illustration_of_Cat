package com.example.assignment2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.lang.reflect.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class SimpleApiHttpClient {

    /**
     * This method will call the theCAT API with a country name(origin) passed in as an argument
     */

    public String fetchData(String urlString){

        //configure the environment to make a HTTP request (this includes an update to the
        //module-info.java file
        HttpRequest request = null;
        HttpResponse<String> response = null;

        // Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create a request
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(urlString)) //uri(URI.create(uri))
                    .GET() // GET is default and can be omitted
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            // Send the request and receive a response
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

        String responseBody = null;

        try{
            // Get the response body as String
            responseBody = response.body();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return responseBody;
    }

    public String fetchCatImage(String catId){

        //https://api.thecatapi.com/v1/images/search?breed_ids=abys&api_key=live_34hi9nUH0V8LMyUDsUZfErtjPa0PD1Jbx03smVDXJtxp2TjO7gv5uXRl9dmilVXi

        String uri = "https://api.thecatapi.com/v1/images/search?breed_ids=" + catId + "&api_key=live_34hi9nUH0V8LMyUDsUZfErtjPa0PD1Jbx03smVDXJtxp2TjO7gv5uXRl9dmilVXi";

        HttpRequest request = null; // declare request outside try block
        HttpResponse<String> response = null;

        // Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create a request
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET() // GET is default and can be omitted
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            // Send the request and receive a response
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

        String responseBody = null;

        try{
            // Get the response body as String
            responseBody = response.body();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return responseBody;
    }

    public String fetchRandomCatImage(){

        //https://api.thecatapi.com/v1/images/search?breed_ids=abys&api_key=live_34hi9nUH0V8LMyUDsUZfErtjPa0PD1Jbx03smVDXJtxp2TjO7gv5uXRl9dmilVXi

        String uri = "https://api.thecatapi.com/v1/images/search";

        HttpRequest request = null; // declare request outside try block
        HttpResponse<String> response = null;

        // Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create a request
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET() // GET is default and can be omitted
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try{
            // Send the request and receive a response
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

        String responseBody = null;

        try{
            // Get the response body as String
            responseBody = response.body();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return responseBody;
    }

    public ArrayList<Cat> parseJsonPosts(String responseBody) {
        Gson gson = new Gson();

        //if the JSON string contains multiple instances of the data represented by the Cat class, the fromJson method would return an ArrayList containing objects of type Cat, with each object representing one instance of the data from the JSON string. Each object in the list would correspond to one set of data in the JSON array.
        //below are three ways

        //1
        //Cat[] catsArray = gson.fromJson(responseBody, Cat[].class);
        //List<Cat> catsList = Arrays.asList(catsArray);
        //return catsList;

        //2
        //return gson.fromJson(httpResponse.body(), Cat.class);

        //3
        Type catListType = new TypeToken<ArrayList<Cat>>(){}.getType();
        ArrayList<Cat> catsList = gson.fromJson(responseBody, catListType);
        return catsList;
    }

    public ArrayList<CatImage> parseJsonImagePosts(String responseBody) {
        Gson gson = new Gson();

        //JsonArray jsonArray = gson.fromJson(responseBody, JsonArray.class);
        //JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        //String url = jsonObject.get("url").getAsString();
        //CatImage catImage = new CatImage();
        //catImage.setUrl(url);
        //return catImage;

        Type catImageListType = new TypeToken<ArrayList<CatImage>>(){}.getType();
        ArrayList<CatImage> catImages = gson.fromJson(responseBody, catImageListType);
        return catImages;
    }


}
