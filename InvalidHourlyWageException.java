/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  February 24, 2025
  InvalidDateException.java
 Exception handling class to handle invalid Hourly Wage
 */

public class InvalidHourlyWageException extends Exception{
    /*
 method: InvalidHourlyWageException
 parameters: message(String)
 return: -
 purpose: Constructor method, creates an InvalidHourlyWageException
*/
    public InvalidHourlyWageException(String message){
        super(message);
    }

}
