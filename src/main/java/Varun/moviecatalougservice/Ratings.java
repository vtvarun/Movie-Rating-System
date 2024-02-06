package Varun.moviecatalougservice;

public class Ratings {

    String userId;

    int movieId;

    int ratings;

    public Ratings(String userId, int movieId, int ratings) {
        this.userId = userId;
        this.movieId = movieId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
