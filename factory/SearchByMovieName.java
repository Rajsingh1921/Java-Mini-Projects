package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

// Concrete product 1 -> finds theatres that are playing a given movie.
class SearchByMovieName implements Search {

    @Override
    public List<Theatre> search(List<Theatre> theatres, String word) {
        List<Theatre> result = new ArrayList<>();

        for (Theatre theatre : theatres) {
            if (isPlaying(theatre, word)) {
                result.add(theatre);
            }
        }
        return result;
    }

    // Goes through every screen and every show of ONE theatre.
    // I return true directly instead of using break, because break only
    // comes out of the inner loop. Then the same theatre gets added twice
    // if two of its screens are playing the same movie.
    private boolean isPlaying(Theatre theatre, String movieName) {
        for (Screen screen : theatre.screens) {
            for (Show show : screen.shows) {
                if (show.movie.movieName.equalsIgnoreCase(movieName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
