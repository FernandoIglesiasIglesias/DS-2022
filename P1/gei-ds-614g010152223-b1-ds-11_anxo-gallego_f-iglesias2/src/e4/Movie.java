package e4;

import java.util.ArrayList;


enum MovieRating {
    NOT_RATED(-1), AWFUL(0), BAD (2), MEDIOCRE (4), GOOD (6), EXCELLENT (8), MASTERPIECE (10);

    private int NumericRating;
    public int getNumericRating() {
        return NumericRating;
    }
    MovieRating(int NumericRating) {
        this.NumericRating=NumericRating;
    }

    public boolean isBetterThan (MovieRating m) {
        return (this.NumericRating > m.NumericRating);
    }
}

public class Movie {

    String movieTitle;
    ArrayList<MovieRating> qualifications;

    public Movie(String title) {
        /*
         * Creates a new movie with the list of ratings empty .
         * @param title Movie title .
         */
        this.movieTitle = title;
        this.qualifications = new ArrayList<>();
    }

    public String getTitle() {
        /*
         * Returns the movie title
         * @return the movie title .
         */
        return (this.movieTitle);
    }

    public void insertRating(MovieRating movieRating) {
        /*
         * Inserts a new movieRating .
         * It is allowed to insert NOT_RATED .
         * @param movieRating MovieRating to be inserted .
         */
        this.qualifications.add(movieRating);
    }

    private boolean isRated() {
        /*
         * Check if this movie has any rating .
         * @return true if and only if there is a valuation other than NOT_RATED .
         */
        boolean rated=false;
        //we look in the list if there is any rating
        for (MovieRating m : this.qualifications) {
            if (m != MovieRating.NOT_RATED) { //if it is different from NOT_RATED we return true
                rated = true;
                break;
            }
        }
        return rated;
    }

    public MovieRating maximumRating() {
        /*
         * Gets the highest rating for this movie .
         * @return maximum rating ; or NOT_RATED if there are no ratings .
         */
        MovieRating higher=MovieRating.NOT_RATED;
        if (isRated()) {
            for (MovieRating actual : this.qualifications) {
                if (actual.isBetterThan(higher)) {
                    higher=actual;
                }
            }
            return higher;
        } else return MovieRating.NOT_RATED;
    }
    public double averageRating() {
        /*
         * Calculate the numerical average rating of this movie .
         * NOT_RATED values are not considered .
         * @return Numerical average rating of this movie .
         * @throws java . util . NoSuchElementException if there are no valid ratings .
         */
        double sum=0.0;
        int totalMarks=0; //counter of how many ratings a movie has
        if (isRated()) {
            for (MovieRating mark : this.qualifications) {
                if (mark != MovieRating.NOT_RATED) {
                    sum = sum + mark.getNumericRating();
                    ++totalMarks;
                }
            }
            return sum/totalMarks; //we return the average
        } else {
            throw new java.util.NoSuchElementException();
        }
    }
}
