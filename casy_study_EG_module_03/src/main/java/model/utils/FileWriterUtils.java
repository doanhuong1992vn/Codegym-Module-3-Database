package model.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtils {
    public static void writeTicket(String ticketCode, String content) {
        final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\tickets\\" + ticketCode + ".txt";
        try (FileWriter fileWriter = new FileWriter(PATH);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void writeFileShowtime(String record) {
        final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\showtime.csv";
        try (FileWriter fileWriter = new FileWriter(PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(record);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
