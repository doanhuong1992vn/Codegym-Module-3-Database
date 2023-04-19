package model.utils;

import case_study_Enjoy_Galaxy.model.builder.movie_builder.IMovieBuilder;
import case_study_Enjoy_Galaxy.model.builder.movie_builder.MovieConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.factory.MovieTheaterFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileReaderUtils {
    public static List<String> readFile(String path) {
        List<String> objectList = new ArrayList<>();
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                objectList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return objectList;
    }

    public static List<Customer> readCustomerData(String path) {
        List<String> propertiesOfCustomerList = readFile(path);
        List<Customer> customerList = new LinkedList<>();
        final int INDEX_OF_FULL_NAME = 0;
        final int INDEX_OF_PHONE_NUMBER = 1;
        final int INDEX_OF_EMAIL = 2;
        final int INDEX_OF_PASSWORD = 3;

        for (String propertiesOfCustomer : propertiesOfCustomerList) {
            if (propertiesOfCustomer.equals(propertiesOfCustomerList.get(0))) { //it's header
                continue;
            }
            String[] properties = propertiesOfCustomer.split(";");
//            customerList.add(new Customer(
//                    properties[INDEX_OF_FULL_NAME],
//                    properties[INDEX_OF_PHONE_NUMBER],
//                    properties[INDEX_OF_EMAIL],
//                    properties[INDEX_OF_PASSWORD]));
        }
        return customerList;
    }

    public static List<Movie> readMovieData(String path) throws ParseException {
        List<String> propertiesOfMovieList = readFile(path);
        List<Movie> movieList = new ArrayList<>();
        final int INDEX_OF_MOVIE_NAME = 0;
        final int INDEX_OF_DIRECTOR = 1;
        final int INDEX_OF_ACTORS = 2;
        final int INDEX_OF_MOVIE_GENRE = 3;
        final int INDEX_OF_PREMIERE_DATE = 4;
        final int INDEX_OF_MOVIE_DURATION = 5;
        final int INDEX_OF_LANGUAGE = 6;
        final int INDEX_OF_CONTENT = 7;

        for (String propertiesOfMovie : propertiesOfMovieList) {
            if (propertiesOfMovie.equals(propertiesOfMovieList.get(0))) {
                continue;
            }
            String[] properties = propertiesOfMovie.split(";");
            IMovieBuilder movieBuilder = new MovieConcreteBuilder()
                    .setMovieDuration(Integer.parseInt(properties[INDEX_OF_MOVIE_DURATION]))
                    .setMovieGenre(properties[INDEX_OF_MOVIE_GENRE])
                    .setName(properties[INDEX_OF_MOVIE_NAME])
                    .setActors(properties[INDEX_OF_ACTORS])
                    .setDirector(properties[INDEX_OF_DIRECTOR])
                    .setContent(properties[INDEX_OF_CONTENT])
                    .setLanguage(properties[INDEX_OF_LANGUAGE])
                    .setStrPremiereDate(properties[INDEX_OF_PREMIERE_DATE]);
            movieList.add(movieBuilder.build());
        }
        return movieList;
    }

    public static List<MovieTheater> readMovieTheaterData(String path) {
        List<String> informationList = readFile(path);
        List<MovieTheater> movieTheaterList = new ArrayList<>();
        final int INDEX_OF_TYPE = 0;
        final int INDEX_OF_NAME = 1;
        final int INDEX_OF_ADDRESS = 2;
        MovieTheaterFactory movieTheaterFactory = MovieTheaterFactory.getInstance();
        for (String lineOfInformationList : informationList) {
            if (lineOfInformationList.equals(informationList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfInformationList.split(";");
            movieTheaterList.add(movieTheaterFactory.getMovieTheater(
                    100,
                    informationArray[INDEX_OF_TYPE],
                    informationArray[INDEX_OF_NAME],
                    informationArray[INDEX_OF_ADDRESS]
            ));
        }
        return movieTheaterList;
    }

}
