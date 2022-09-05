package com.example.moviefacts.controller;

import com.example.moviefacts.repository.MovieRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// The controller is responsible for receive requests and return
// respones to the client
//Frameworket starter controlleren

@RestController
public class MovieController {


    @GetMapping("/")
    public String index(){
        return "Welcome to Movie Facts <br> " +
            "<b>/getFirst</b> returns first movie in database";
    }

    @GetMapping("/getFirst")
    public String getFirst(){
        MovieRepository movieRepository = new MovieRepository();
        String responseText = "<h1>First movie in database</h1>";
        responseText += movieRepository.getFirst();
        return responseText;
   }


    @GetMapping("/getRandom")
    public String getRandom(){
        MovieRepository movieRepository = new MovieRepository();
        return movieRepository.getRandom();
    }

  @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
      MovieRepository movieRepository = new MovieRepository();
      return movieRepository.getTenSortByPopularity();
  }

  @GetMapping("/howManyWonAnAward")
  public String howManyWonAnAward(){
    MovieRepository movieRepository = new MovieRepository();
    return movieRepository.howManyWonAnAward();
  }

  //TODO Skal den have en annotation med Filter etc??
  @GetMapping("/filter?char='x'amount='n'")
  public String filterCharX(){
    MovieRepository movieRepository = new MovieRepository();
    return movieRepository.filterCharX('a', 4);
  }

}
