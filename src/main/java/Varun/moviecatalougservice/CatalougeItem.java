package Varun.moviecatalougservice;

import java.util.List;

public class CatalougeItem {


    private int movieRatings;

    private Movie movie;


    public CatalougeItem(int movieRatings, Movie movie) {
        this.movieRatings = movieRatings;
        this.movie = movie;
    }

    public int getMovieRatings() {
        return movieRatings;
    }

    public void setMovieRatings(int movieRatings) {
        this.movieRatings = movieRatings;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
