// 2. A method named average() has one argument that is an array of strings. It converts these 
// to double values and returns their average. The method generates a NullPointerException 
// if a array elements is null or NumberFormatException if an element is incorrectly 
// formatted. Write a program that illustrates how to declare and use this method. Include 
// throws clause in the method declaration to indicate that these problems can occur.
class AverageCalculator {
    // Method to calculate the average of an array of strings
    public static double average(String[] numbers) throws NullPointerException, NumberFormatException {
        if (numbers == null) {
            throw new NullPointerException("The array is null.");
        }

        double sum = 0.0;
        int count = 0;

        for (String num : numbers) {
            if (num == null) {
                throw new NullPointerException("One of the elements in the array is null.");
            }
            try {
                sum += Double.parseDouble(num);
                count++;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid number format: " + num);
            }
        }

        if (count == 0) {
            throw new ArithmeticException("Cannot calculate the average of an empty array.");
        }

        return sum / count;
    }

    public static void main(String[] args) {
        String[] data = {"10.5", "20.3", "hi", null, "40.2"};
        try {
            double avg = average(data);
            System.out.println("The average is: " + avg);
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
