package com.university.java.semester5.designpatterns.factory;

// THE FACTORY (the main part of this assignment)
// It has only one job: look at what the user picked and
// give back the correct Search object.
//
// Why this is useful: if tomorrow we want "search by language",
// we just make a SearchByLanguage class and add one more case here.
// SearchController and Main don't change at all.
class Factory {

    public Search getInstance(SearchBy filter) {
        switch (filter) {
            case MOVIE_NAME:
                return new SearchByMovieName();
            case ACTOR_NAME:
                return new SearchByActorName();
            default:
                throw new IllegalArgumentException("Invalid search: " + filter);
        }
    }
}
