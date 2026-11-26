package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

// Theatre -> has many Screens -> each Screen has many Shows
//         -> each Show has a Movie
class Theatre {
    String name;
    Location location;
    List<Screen> screens = new ArrayList<>();

    Theatre(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
