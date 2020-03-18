package movieListQuestion;

import java.util.Map;
import java.util.TreeMap;


public class MovieList {

    Map<String, String> movieList; // mapping from movie name to rating

    public MovieList() {
        movieList = new TreeMap<String, String>(); // use tree map to sort by key
    }

    /**
     * Adds a movie to the list.
     * @param movieName the name of the new movie
     * @throws MovieListException if the movie is already in the list
     */
    public void addMovie(String movieName) throws MovieListException {
        if (movieList.containsKey(movieName))
            throw new MovieListException("Duplicate movie: " + movieName);
        else
            movieList.put(movieName, "No rating"); // default dummy rating
    }

    /**
     * Gets the rating associated with a particular movie.
     * @param movieName the name of the movie whose rating we want
     * @return the rating (in stars) associated with the movie, or "No rating"
     * if the movie has not had a rating associated with it
     * @throws MovieListException if the movie named is not in the list
     */
    public String getRating(String movieName) throws MovieListException {
        if (movieList.containsKey(movieName))
            return movieList.get(movieName);
        else
            throw new MovieListException("Unknown movie: " + movieName);
    }

    public void setRating(String movieName, int numStars) throws MovieListException {
        if (numStars < 1 || numStars > 5)
            throw new MovieListException("Number of stars out of range");
        if (!movieList.containsKey(movieName))
            throw new MovieListException("Unknown movie: " + movieName);
        String stars = "";
        for (int star = 0; star < numStars; star++) stars +="*";
        movieList.put(movieName, stars);
    }


    public String getList() {
        String wholeList = "";
        for (String movieName : movieList.keySet()) {
            wholeList += movieName + "\n";
        }
        return wholeList;
    }
}
