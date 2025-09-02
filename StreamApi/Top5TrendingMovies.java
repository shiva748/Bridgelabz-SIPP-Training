package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

class Movie {
    String title;
    double rating;
    int releaseYear;

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - Rating: " + rating;
    }
}

public class Top5TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2021),
                new Movie("Movie B", 9.0, 2020),
                new Movie("Movie C", 7.5, 2022),
                new Movie("Movie D", 8.7, 2021),
                new Movie("Movie E", 9.2, 2019),
                new Movie("Movie F", 8.0, 2023),
                new Movie("Movie G", 9.5, 2021));

        List<Movie> topMovies = movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Comparator.comparingInt(Movie::getReleaseYear).reversed()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Trending Movies:");
        topMovies.forEach(System.out::println);
    }
}
