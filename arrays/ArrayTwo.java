// 2) Write a program in Java to create variable size array. Data can be numeric.
//  Flush an array
//  add a number at a specified location in an anay.
//  display the array

    class ArrayTwo{
        public static void main(String[] args){
            
            int[] arr = {1,2,3,4,5,6,7,8};
            for(int i=0;i<arr.length;i++){
                System.out.println("array is a.. " + arr[i]);
            }
            System.out.println("------------------");
            int value = 100;
            int size = 4;

            for(int i = arr.length-1;i>=size;i--){
                // arr[i+1] = arr[i];
             arr[i] = arr[i - 1];
            }
            arr[size] = value;
            

            for(int i=0;i<arr.length;i++){
                System.out.println("array is a.. " + arr[i]);
            }
             System.out.println("flush an array..");
        for(int i=0;i<arr.length;i++){
            arr[i] = 0;

        }
        for(int i =0;i<arr.length;i++){
            System.out.println("arr"+arr[i]);
        }
        }

       
    }