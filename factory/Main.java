package com.university.java.semester5.designpatterns.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Movie Finder - a small BookMyShow style app I made to practice
// the Factory Design Pattern.
// How to use: run this file, pick 1 or 2, then type a movie or actor name.
public class Main {

    public static void main(String[] args) {

        // ----- sample data (a real app would load this from a database) -----
        Location userLocation = new Location("Pune", 18.52, 73.86);

        Movie chhaava = new Movie("Chhaava", new Actor("Vicky Kaushal"));
        Movie pushpa2 = new Movie("Pushpa 2", new Actor("Allu Arjun"));
        Movie jawan = new Movie("Jawan", new Actor("Shah Rukh Khan"));
        Movie pathaan = new Movie("Pathaan", new Actor("Shah Rukh Khan"));
        Movie twelfthFail = new Movie("12th Fail", new Actor("Vikrant Massey"));

        Theatre pvr = new Theatre("PVR Phoenix Marketcity, Viman Nagar",
                new Location("Pune", 18.56, 73.92));
        pvr.screens.add(screenWith(chhaava, jawan));
        pvr.screens.add(screenWith(chhaava)); // Chhaava on 2 screens here

        Theatre inox = new Theatre("INOX Bund Garden",
                new Location("Pune", 18.54, 73.88));
        inox.screens.add(screenWith(pushpa2, pathaan));

        Theatre cinepolis = new Theatre("Cinepolis Seasons Mall, Hadapsar",
                new Location("Pune", 18.52, 73.93));
        cinepolis.screens.add(screenWith(chhaava, pushpa2));

        Theatre cityPride = new Theatre("City Pride, Kothrud",
                new Location("Pune", 18.50, 73.81));
        cityPride.screens.add(screenWith(jawan, pushpa2));

        // this one is in Mumbai, so a user sitting in Pune should never see it
        Theatre mumbai = new Theatre("PVR Icon, Andheri",
                new Location("Mumbai", 19.13, 72.83));
        mumbai.screens.add(screenWith(twelfthFail, chhaava));

        List<Theatre> allTheatres =
                Arrays.asList(pvr, inox, cinepolis, cityPride, mumbai);
        SearchController controller = new SearchController();
        Scanner sc = new Scanner(System.in);

        // ----- menu -----
        System.out.println("==============================================");
        System.out.println("     MOVIE FINDER  (Factory Design Pattern)");
        System.out.println("==============================================");
        System.out.println("Your location : " + userLocation.city);
        System.out.println("Movies : Chhaava, Pushpa 2, Jawan, Pathaan, "
                + "12th Fail");
        System.out.println("Actors : Vicky Kaushal, Allu Arjun, "
                + "Shah Rukh Khan, Vikrant Massey");

        while (true) {
            System.out.println();
            System.out.println("1. Search by movie name");
            System.out.println("2. Search by actor name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextLine()) {
                break; // input closed, nothing more to read
            }
            String choice = sc.nextLine().trim();

            SearchBy filter;
            String askFor;

            if (choice.equals("1")) {
                filter = SearchBy.MOVIE_NAME;
                askFor = "movie name";
            } else if (choice.equals("2")) {
                filter = SearchBy.ACTOR_NAME;
                askFor = "actor name";
            } else if (choice.equals("0")) {
                System.out.println("Thanks for using Movie Finder. Bye!");
                break;
            } else {
                System.out.println("Oops! Please enter 1, 2 or 0.");
                continue;
            }

            System.out.print("Enter " + askFor + ": ");
            if (!sc.hasNextLine()) {
                break;
            }
            String word = sc.nextLine().trim();

            List<Theatre> result =
                    controller.search(userLocation, word, filter, allTheatres);
            printResult(word, result);
        }

        sc.close();
    }

    // small helper so I don't have to write shows.add(...) again and again
    private static Screen screenWith(Movie... movies) {
        Screen screen = new Screen();
        for (Movie movie : movies) {
            screen.shows.add(new Show(movie));
        }
        return screen;
    }

    private static void printResult(String word, List<Theatre> result) {
        if (result.isEmpty()) {
            System.out.println("Sorry, no theatre near you is showing \""
                    + word + "\" right now.");
            return;
        }

        System.out.println("Theatres near you for \"" + word + "\":");
        int count = 1;
        for (Theatre theatre : result) {
            System.out.println("  " + count + ". " + theatre.name);
            count++;
        }
    }
}
