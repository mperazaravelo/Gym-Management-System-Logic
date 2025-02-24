/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  February 24, 2025
  InvalidDateException.java
 Exception handling class to handle invalid ID
 */
public class InvalidIDRangeException extends Exception{
    /*
   method: InvalidIDRangeException
   parameters: message(String)
   return: -
   purpose: Constructor method, creates an InvalidIDRangeException
  */
    public InvalidIDRangeException(String message){
        super(message);
    }

}
