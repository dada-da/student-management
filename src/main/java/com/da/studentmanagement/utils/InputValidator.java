package com.da.studentmanagement.utils;

import java.util.Scanner;

public class InputValidator {
    public static String getRequiredInput(Scanner scanner, String prompt, String errorMsg) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isBlank()) {
                System.out.println(errorMsg);
            }
        } while (input.isBlank());
        return input;
    }
}
