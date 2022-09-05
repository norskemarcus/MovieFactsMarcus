package com.example.moviefacts.repository;

import com.example.moviefacts.model.Movie;

import java.util.Comparator;

public class PopularityComparator implements Comparator<Movie> {

  @Override
  public int compare(Movie o1, Movie o2) {
    return o1.getPopularity() - o2.getPopularity();
  }
}
