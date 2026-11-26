package com.university.java.semester5.designpatterns.factory;

// All the ways a user can search in our app.
// I used an enum instead of plain Strings so nobody can pass
// something wrong like "moviename" or "Actor" by mistake.
enum SearchBy {
    MOVIE_NAME,
    ACTOR_NAME
}
