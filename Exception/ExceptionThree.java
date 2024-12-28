// 3. Write a program which creates an Array of character. Make one function with one 
// argument as a character and that function throw a user defined exception if the character 
// that u have passed is digit.
import java.util.*;
class DigitException extends Exception{
    public DigitException(String num){
        super(num);
    }
}
class ExceptionThreeCheck{
         public void arraycheck(char ch) throws DigitException{
            if(Character.isDigit(ch)){
                // throw new DigitException(ch);
                throw new DigitException("Error: The character '" + ch + "' is a digit.");
            }
            else{
                System.out.println("number us vaid : " + ch);
            }
         }
}
class ExceptionThree{
public static void main(String[] args){
         
         ExceptionThreeCheck ep = new ExceptionThreeCheck();
        char[] digitarr = {'a','b','c', '1','e','f','g'};

        for(char digitch : digitarr){
            try{
               ep.arraycheck(digitch);
            }
            catch(DigitException e){
                System.out.println(e.getMessage());
            }

        }
    }
}