package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

// Concrete product 2 -> finds theatres playing any movie of a given actor.
class SearchByActorName implements Search {

    @Override
    public List<Theatre> search(List<Theatre> theatres, String word) {
        List<Theatre> result = new ArrayList<>();

        for (Theatre theatre : theatres) {
            if (hasActor(theatre, word)) {
                result.add(theatre);
            }
        }
        return result;
    }

    // same idea as SearchByMovieName, only here we check the actor name
    private boolean hasActor(Theatre theatre, String actorName) {
        for (Screen screen : theatre.screens) {
            for (Show show : screen.shows) {
                if (show.movie.actor.name.equalsIgnoreCase(actorName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
