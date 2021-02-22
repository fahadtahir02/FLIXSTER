package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {

    /*
   1 stated movie Id to allow for us to get the video right for every movie
   instead of hardcoding it for every movie because that wouldn't really work.
   */
    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;
    // Empty constructer as per Parcel requirement
    public Movie(){}


    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
        //^After assigning movie Id we have to now add it as a Json Object and int because the dta itself is an int
        // however the name referring to the data which is "id" is a string thats why it was assigned as a string.
        // NEXT we wll add a getter constructor for this below as we did for all of the listed Json objects.



    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));

        }
        return movies;

    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }
    // 2 Generating Getter below for  movieID
    public int getMovieId() {
        return movieId;
    }
}
