package com.reva.exam.util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner = new Scanner(System.in);

    public String readText(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        if (!scanner.hasNextLine()) return "";
        return scanner.nextLine().trim();
    }

    public String readRequired(String prompt) {
        while (true) {
            String value = readText(prompt);
            if (!value.isBlank()) return value;
            System.out.println("This field cannot be empty.");
        }
    }

    public String readEmail(String prompt) {
        while (true) {
            String email = readRequired(prompt);
            if (email.contains("@") && email.contains(".")) return email;
            System.out.println("Enter a valid email address.");
        }
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            String value = readText(prompt);
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) return number;
            } catch (NumberFormatException ignored) { }
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
    }

    public boolean confirm(String prompt) {
        while (true) {
            String value = readText(prompt + " [Y/N]: " );
            if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("YES")) return true;
            if (value.equalsIgnoreCase("N") || value.equalsIgnoreCase("NO")) return false;
            System.out.println("Please enter Y or N.");
        }
    }
}
