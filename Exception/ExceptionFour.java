// 4. Write a program which creates an array of Date in form (dd/mm/yy). Analyze each 
// element and check whether the date is correct or not. If the date is wrong then throw a 
// User defined Exception DateException and display the appropriate message. If the Date 
// is correct then display the date in this format. For example, if the date is 9/9/06 then 
// display the date like 9th September 2006. You are able to display all the dates in the 
// given String and for the date which is not proper, display the appropriate message

import java.util.*;

// Custom Exception for Invalid Date
class DateException extends Exception {
    public DateException(String message) {
        super(message);
    }
}

class DateValidation {
    // Function to validate and format the date
    public static void validateAndFormatDate(String date) throws DateException {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        try {
            // Split the date into day, month, and year
            String[] parts = date.split("/");
            if (parts.length != 3) {
                throw new DateException("Invalid date format: " + date);
            }

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]) + 2000; // Convert yy to yyyy

            // Check if the month is valid
            if (month < 1 || month > 12) {
                throw new DateException("Invalid month in date: " + date);
            }

            // Check if the day is valid for the given month
            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Handle leap years for February
            if (month == 2 && isLeapYear(year)) {
                daysInMonth[1] = 29;
            }

            if (day < 1 || day > daysInMonth[month - 1]) {
                throw new DateException("Invalid day in date: " + date);
            }

            // Format the date
            String daySuffix = getDaySuffix(day);
            System.out.println(day + daySuffix + " " + months[month - 1] + " " + year);
        } catch (NumberFormatException e) {
            throw new DateException("Invalid numeric value in date: " + date);
        }
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to get the suffix for the day (st, nd, rd, th)
    private static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public static void main(String[] args) {
        // Array of dates in dd/mm/yy format
        String[] dates = {"09/09/06", "31/02/22", "15/08/45", "29/02/20", "32/01/21"};

        for (String date : dates) {
            try {
                validateAndFormatDate(date);
            } catch (DateException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
