package com.solvians.showcase;

import java.security.SecureRandom;

public class ISINGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generate ISIN string.
     */
    public static String generateISIN() {
        StringBuilder isin = new StringBuilder();

        // First, append 2 letters
        isin.append(randomUppercase(2));

        // Second, append 9 alphanumeric characters
        for (int i = 0; i < 9; i++) {
            isin.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        // Third, Calculate check digit and append it
        int checkDigit = calculateCheckDigit(isin.toString());
        isin.append(checkDigit);
        return isin.toString();
    }

    private static String randomUppercase(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return result.toString();
    }

    private static int calculateCheckDigit(String isin) {
        StringBuilder converted = new StringBuilder();
        for (char c : isin.toCharArray()) {
            if (Character.isDigit(c)) {
                converted.append(c);
            } else {
                int num = c - 'A' + 10;
                converted.append(num);
            }
        }
        int sum = 0;
        for (int i = converted.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(converted.charAt(i));
            if ((converted.length() - i) % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        return (10 - (sum % 10)) % 10;
    }
}
