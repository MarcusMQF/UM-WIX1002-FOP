public class viva2Q4 {
    public static void main(String[] args) {
        // Sample input
        String[] isbnList = {"123456789X", "1234567890", "04719588697"};

        // Validate the list of ISBNs
        boolean[] validationResults = validateISBNList(isbnList);

        // Print the results
        System.out.print("The validation results are: ");
        for (boolean result : validationResults) {
            System.out.print(result + " ");
        }
    }

    // Method to validate a single ISBN-10 number
    public static boolean isValidISBN(String isbn) {
        // Check if the length is exactly 10 characters
        if (isbn.length() != 10) {
            return false;
        }

        // Check if the first 9 characters are digits
        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        // Check if the last character is a digit or 'X'
        char lastChar = isbn.charAt(9);
        if (!Character.isDigit(lastChar) && lastChar != 'X') {
            return false;
        }

        // Calculate the weighted sum of the first 9 digits
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (i + 1) * digit;
        }

        // Calculate the check digit
        int checkDigit;
        if (lastChar == 'X') {
            checkDigit = 10;
        } else {
            checkDigit = Character.getNumericValue(lastChar);
        }

        // Validate the check digit
        return (sum % 11) == checkDigit;
    }

    // Method to validate a list of ISBN-10 numbers
    public static boolean[] validateISBNList(String[] isbnList) {
        boolean[] results = new boolean[isbnList.length];
        for (int i = 0; i < isbnList.length; i++) {
            results[i] = isValidISBN(isbnList[i]);
        }
        return results;
    }
}