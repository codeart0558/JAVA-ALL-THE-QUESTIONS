// Write a class called Statistics, which has a static method called average, which takes a one
// dimensional array for double type, as parameter, and prints the average for the values in the
// array.
// a. Now write a class with the main method, which creates a two-dimensional array for the
// four weeks of a month, containing minimum temperatures for the days of the week(an
// array of 4 by 7), and uses the average method of the Statistics class to compute and
// print the average temperatures for the four weeks.

    class Statistics{
            public static void average(double[] array){
                double sum =0;
                for(double value : array){
                    sum += value;
                }
                // double avg = sum / value.length;
                double avg = sum / array.length;



                System.out.printf("temperatures: %.2f\n",avg);
            }
    }

    class TwoDimensionArray{
        public static void main(String[] args){
            double[][] arr = {
                {1.1,1.2,1.3,1.4,1.5,1.6,1.7},
                {2.1,2.2,2.3,2.4,2.5,2.6,2.7},
                {3.1,3.2,3.3,3.4,3.5,3.6,3.7},
                {3.1,3.2,3.3,3.4,3.5,3.6,3.7}
            };
            
        for(int i=0; i < arr.length ;i++){
            System.out.println("number : " + (i + 1));
            Statistics.average(arr[i]);
        } 
        }

    }   
