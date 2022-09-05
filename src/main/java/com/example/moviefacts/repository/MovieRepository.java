package com.example.moviefacts.repository;

import com.example.moviefacts.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;


//The class that interact with data (databases or API's)
// The repository = data access layer (bliver brugt af Service/model layer)

@Repository
public class MovieRepository {

   private ArrayList<Movie> listOfMovies = new ArrayList<>();
   private Movie randomMovie;

    public ArrayList<Movie> getAllMovies() {

      try {
        File file = new ClassPathResource("imdb-data.csv").getFile();
        Scanner input = new Scanner(file);

        input.nextLine(); // hoppe over første linje med overskrifter

        while (input.hasNextLine()) {

          Scanner lineScanner = new Scanner(input.nextLine()).useDelimiter(";");

          int year = lineScanner.nextInt();
          int lenght = lineScanner.nextInt();
          String title = lineScanner.next();
          String subject = lineScanner.next();
          int popularity = lineScanner.nextInt();
          boolean result = lineScanner.next().equals("Yes");

          Movie movieFromCsv = new Movie(year, lenght, title, subject, popularity, result);
          listOfMovies.add(movieFromCsv);
        }
      } catch (IOException e) {
            System.out.println("Error reading file: " + e);
      }
        return listOfMovies;
    }



    public Movie getFirst() {
    ArrayList<Movie> list = getAllMovies();
    return list.get(0);
    }


    public String getRandom() {
    ArrayList<Movie> list = getAllMovies();
    Random random = new Random();
    randomMovie = list.get(random.nextInt(list.size()));

    String randomMovieReturn = randomMovie.getTitle();
    return randomMovieReturn;
    }


    public String getTenSortByPopularity() {
      ArrayList<Movie> allMovies = getAllMovies();
      List<Movie> listOf10movies = new ArrayList<>();
      // Set<Movie> setOf10Movies = new TreeSet<>(new PopularityComparator());
      //setOf10Movies.addAll(listOf10movies);

      for (int i = 0; i < 10 ; i++) {
        Random random = new Random();
        Movie movie = allMovies.get(random.nextInt(allMovies.size()));

        if(!listOf10movies.contains(movie)){
          listOf10movies.add(movie);
        }
      }

      PopularityComparator pc = new PopularityComparator();
      listOf10movies.sort(pc);

      return listOf10movies.toString(); //TODO: Hvordan print ud uden klammer?
    }


    public String howManyWonAnAward(){
      ArrayList<Movie> allMovies = getAllMovies();
      int count = 0;
      for (Movie allMovie : allMovies) {

        if (allMovie.isHasAwards()) {
          count++;
        }
      }
      return "How many movies won an award? " + count;
    }

    public String filterCharX(char x, int n){
      //prints all movies, but only if they contain x character n amount of times
      ArrayList<Movie> allMovies = getAllMovies();
      ArrayList<Movie> moviesWithCharX = new ArrayList<>();
     // CharacterIterator itr = new StringCharacterIterator(allMovies.toString());

    //  while(itr.current() != CharacterIterator.DONE){
     // }

      int count = 0;
      for (int i = 0; i < allMovies.size(); i++) {

       if(allMovies.toString().charAt(i) == x){
         moviesWithCharX.add(allMovies.get(i));
         count++;
       }

       if(count == n){
         return moviesWithCharX.toString();
       }
      }
      return "Det fandtes ikke nogle filmer med " + x + " " + n + "antal gange";
    }
}
