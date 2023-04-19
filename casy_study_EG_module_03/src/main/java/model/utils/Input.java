package model.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int choiceIntegerPrompt(String request) {
        int output;
        do {
            try {
                System.out.println(request);
                output = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Incorrect format : " + e.getMessage());
            }
        } while (true);
        return output;
    }

    public static String prompt(String request) {
        System.out.println(request);
        return scanner.nextLine();
    }

    public static String prompt(String request, String regexPattern) {
        String text;
        do {
            text = prompt(request);
            if (Validation.invalidate(text, regexPattern)) {
                System.err.println("Invalid input! Incorrect format!");
            }
        } while (Validation.invalidate(text, regexPattern));
        return text;
    }

    public static int promptOfMonth(String request) {
        int output;
        do {
            try {
                System.out.println(request);
                output = Integer.parseInt(scanner.nextLine());
                if (output < 1 || output > 12) {
                    System.err.println("Tháng " + output + " không tồn tại");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Incorrect format : " + e.getMessage());
            }
        } while (true);
        return output;
    }
}
