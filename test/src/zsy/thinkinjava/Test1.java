package zsy.thinkinjava;

import java.util.*;

// See in chapter 11.
public class Test1 {
    public static void main(String[] args) {
        MovieGenerator movieGenerator =
                new MovieGenerator("Harry Porter", "Star Wars", "Snow White");
        String[] a = new String[100];

        for (int i = 0; i < 100; i++) {
            a[i] = movieGenerator.next();
        }
        System.out.println(Arrays.toString(a));
    }
}

class MovieGenerator {
    private final String[] movies;
    private int index = 0;

    public MovieGenerator(String... movies) {
        this.movies = movies;
    }

    public String next() {
        if (index >= movies.length) index = 0;
        return movies[index++];
    }

    public int length() {
        return movies.length;
    }
}
