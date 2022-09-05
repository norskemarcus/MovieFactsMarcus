package com.example.moviefacts.model;


// Models represent domain objects

import org.springframework.stereotype.Service;

@Service
public class Movie {

  private int year;
  private int length;
  private String title;
  private String subject;
  private int popularity;
  private boolean hasAwards;

  // spring needs an empty constructor!
  public Movie() {
  }

  public Movie(int year, int length, String title, String subject, int popularity, boolean hasAwards) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.hasAwards = hasAwards;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public boolean isHasAwards() {
    return hasAwards;
  }

  public void setHasAwards(boolean hasAwards) {
    this.hasAwards = hasAwards;
  }

  @Override
  public String toString() {
    //Year;Length;Title;Subject;Popularity;Awards
    String s = "<p> Title: " + getTitle() + " " + "popularity: " + getPopularity() + "</p>";
    return s;
  }

}
