package com.university.java.semester5.designpatterns.factory;

// Movie HAS-A Actor (has-a relationship we did in class)
class Movie {
    String movieName;
    Actor actor;

    Movie(String movieName, Actor actor) {
        this.movieName = movieName;
        this.actor = actor;
    }
}
