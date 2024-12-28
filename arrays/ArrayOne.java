// 1) Write application that creates an array of double, to provide following functionality.
//  display the length of the array and its elements.
//  Display an array. (Use for each version of loop for display).
//  compute the sume of the squares of these numbers.
//  Determine Mean and Median of an array.
//  Sort an array – Ascending and Descending. Use any two sorting algorithm. User can also
// select the sorting method.
//  Search an element from the array, i.e. returns the location of the element of an array
// that matches an indicated value.
//  Copy of an array.
//  Reverse of an array.


        // // using for loop
        // for(int i=0;i<len;i++){
        //     System.out.println("array print using for loop ..." +  i + " : " + array[i]);
        // }

        // // using foreach loop
        // for(double value : array){
        //     System.out.println("array  print using foreach loop ..." + value);
        // }

        // // using while loop
        // int i=0;
        // while(i < array.length){
        //     System.out.println("array print using while loop ... " + i + " : " + array[i]);
        //     i++;
        // }

        // // comput the sum of squre of this number

        // double sum = 0;
        // double store;
        
        // for(double value : array){
        //     store = value * 2;
        //     sum += store;            
        // }
        // System.out.println("sum of squre of this number .. " + sum);
        
class ArrayOne {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 44, 5, 6, 7, 8, 9, 10};

        // Display the length of the array and its elements
        double len = array.length;
        System.out.println("Length of the array is: " + len);

        // // Using foreach loop to display elements
        // System.out.println("Array elements:");
        // for (double value : array) {
        //     System.out.println(value);
        // }

        // // Compute the sum of the squares of these numbers
        // double sum = 0;
        // for (double value : array) {
        //     sum += value * value;
        // }
        // System.out.println("Sum of the squares of the numbers: " + sum);

        // // Sort the array in ascending order (First Method)
        // for (int i = 0; i < len - 1; i++) {
        //     for (int j = i + 1; j < len; j++) {
        //         if (array[j] < array[i]) {
        //             double temp = array[i];
        //             array[i] = array[j];
        //             array[j] = temp;
        //         }
        //     }
        // }

        // // Print sorted array (Ascending Order)
        // System.out.println("\nSorted array in ascending order:");
        // for (double num : array) {
        //     System.out.println(num);
        // }

        // // Sort the array in descending order (First Method)
        // for (int i = 0; i < len - 1; i++) {
        //     for (int j = i + 1; j < len; j++) {
        //         if (array[j] > array[i]) {
        //             double temp = array[i];
        //             array[i] = array[j];
        //             array[j] = temp;
        //         }
        //     }
        // }

        // // Print sorted array (Descending Order)
        // System.out.println("\nSorted array in descending order:");
        // for (double num : array) {
        //     System.out.println(num);
        // }

        // // Sort the array in ascending order using Bubble Sort (Second Method)
        // for (int i = 0; i < array.length - 1; i++) {
        //     for (int j = 0; j < array.length - i - 1; j++) {
        //         if (array[j] > array[j + 1]) {
        //             double temp = array[j];
        //             array[j] = array[j + 1];
        //             array[j + 1] = temp;
        //         }
        //     }
        // }

        // // Print sorted array (Ascending Order)
        // System.out.println("\nSorted array in ascending order (Bubble Sort):");
        // for (double num : array) {
        //     System.out.println(num);
        // }

        // // Sort the array in descending order using Bubble Sort (Second Method)
        // for (int i = 0; i < array.length - 1; i++) {
        //     for (int j = 0; j < array.length - i - 1; j++) {
        //         if (array[j] < array[j + 1]) {
        //             double temp = array[j];
        //             array[j] = array[j + 1];
        //             array[j + 1] = temp;
        //         }
        //     }
        // }

        // // Print sorted array (Descending Order)
        // System.out.println("\nSorted array in descending order (Bubble Sort):");
        // for (double num : array) {
        //     System.out.println(num);
        // }

        // // Copy the array
        // double[] arrayCopy = array.clone();
        // System.out.println("\nCopied array:");
        // for (double num : arrayCopy) {
        //     System.out.println(num);
        // }

        // // Reverse the array
        // double[] reversedArray = new double[array.length];
        // for (int i = 0; i < array.length; i++) {
        //     reversedArray[i] = array[array.length - 1 - i];
        // }
        // System.out.println("\nReversed array:");
        // for (double num : reversedArray) {
        //     System.out.println(num);
        // }

        // revers eof an array

        // for(int i = (int)len-1;i>=0;i--){
        //     System.out.println("reverse element : " + array[i]);
        // }

        // copy of an array

    //     double[] carr = new double[array.length];
        
    //     for(int i=0;i<len;i++){
    //         carr[i] = array[i];
           
    //     }

    //     // print copy array
    //     for(int i=0;i<carr.length;i++){
    //         System.out.println("copy array is .." + carr[i]);
    //     }

    // }
}
