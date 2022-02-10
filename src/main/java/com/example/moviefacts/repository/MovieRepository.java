package com.example.moviefacts.repository;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MovieRepository {
    //læse movies

    public String findAll() {
        try {
            //findAll
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                //her skal den enkelte linie behandles og movies oprettes
                //men vi skriver bare ud...
                System.out.println(input.next());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        return "her skal filmene komme";
    }
}
