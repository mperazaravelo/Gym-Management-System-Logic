/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  February 24, 2025
  InvalidDateException.java
 Exception handling class to handle invalid Date
 */

public class InvalidDateException extends Exception{
    /*
method: InvalidDateException
parameters: message(String)
return: -
purpose: Constructor method, creates an InvalidDateException
*/
    public InvalidDateException(String message){
        super(message);
    }
}
