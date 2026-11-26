package com.university.java.semester5.designpatterns.factory;

import java.util.List;

// This is the common interface (the "product") for every type of search.
// The Factory always returns a Search, so whoever uses it
// does not need to know which exact class is behind it.
interface Search {
    List<Theatre> search(List<Theatre> theatres, String word);
}
