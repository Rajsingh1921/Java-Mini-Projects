package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

// Think of this as the backend of the app. It does 3 things:
//   1) keeps only the theatres near the user
//   2) asks the Factory for the right Search object
//   3) runs that search and returns the result
class SearchController {

    private final Factory factory = new Factory();

    public List<Theatre> search(Location userLocation, String word,
                                SearchBy filter, List<Theatre> allTheatres) {

        // step 1 - filter out theatres that are far away
        List<Theatre> nearby = new ArrayList<>();
        for (Theatre theatre : allTheatres) {
            if (theatre.location.isNear(userLocation)) {
                nearby.add(theatre);
            }
        }

        // step 2 - notice there is no "new SearchByMovieName()" here.
        // The controller doesn't decide, the factory does.
        Search search = factory.getInstance(filter);
        System.out.println("[Factory] created -> "
                + search.getClass().getSimpleName());

        // step 3
        return search.search(nearby, word);
    }
}
