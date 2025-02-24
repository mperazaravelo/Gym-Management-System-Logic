/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  February 24, 2025
  GymEmployee.java
  Class that contains the methods that are used in the GMS
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GymManagementSystem {
    //Attribute
    private List<GymEmployee> employees;

    /*
     method: GymManagementSystem
     parameters: None
     return: -
     purpose: Constructor method, creates a GymManagementSystem object
    */
    public GymManagementSystem(){
    employees = new ArrayList<>();

}

    /*
          method: newEmployeeFromFile
          parameters: path(String)
          return: void
          purpose: reads the contents of a file using the file path, breaks them into Employee id, name,
          last name, job title, hourly wage, and date enrolled, and creates a new GymEmployee object to be added to the
          employees list
         */
    public void newEmployeeFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line; //line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int employee_id = Integer.parseInt(parts[0]);
                    String employee_name = parts[1];
                    String employee_last_name = parts[2];
                    String job_title = parts[3];
                    double hourly_wage = Double.parseDouble(parts[4]);
                    String date_enrolled = parts[5];
                    employees.add(new GymEmployee(employee_id, employee_name, employee_last_name, job_title, hourly_wage, date_enrolled));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    /*
      method: newEmployeeManually
      parameters: scanner(Scanner)
      return: void
      purpose: prompts the user to input id, name, last name, job title, hourly wage, and date enrolled,
      and creates a new GymEmployee object to be added to the employees list
     */
    public void newEmployeeManually(Scanner scanner) {
        try {
            System.out.print("Enter an ID between 1 and 9999999: ");
            int id = scanner.nextInt();
            if (id < 1 || id > 9999999) {
                throw new InvalidIDRangeException("The ID number must be between 1 and 9999999. Try again: ");
            }
            // Consume the newline character
            scanner.nextLine();

            System.out.print("Enter a name: ");
            String name = scanner.nextLine();
            System.out.print("Enter a last name: ");
            String last_name = scanner.nextLine();
            System.out.print("Enter the Job Title: ");
            String job_title = scanner.nextLine();
            System.out.print("Enter the Hourly Wage: ");
            double hourly_wage = scanner.nextDouble();
            if (hourly_wage < 12.00 || hourly_wage > 40.00) {
                throw new InvalidHourlyWageException("The Hourly Wage must be between $12.00 and $40.00");
            }
            // Consume the newline left-over from nextDouble()
            scanner.nextLine();

            System.out.print("Enter the Date enrolled (YYYY-MM-DD): ");
            String date_enrolled = scanner.nextLine();
            // Validate the date input format
            if (!date_enrolled.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new InvalidDateException("The date must be formatted as YYYY-MM-DD");
            }

            employees.add(new GymEmployee(id, name, last_name, job_title, hourly_wage, date_enrolled));
            System.out.println("Employee has been added.");
        }
        catch (InvalidIDRangeException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidHourlyWageException e) {
            System.out.println(e.getMessage());
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
      method: removeEmployeeById
      parameters: id (int)
      return: void
      purpose: Removes an employee from the employees list given its id
     */

    public void removeEmployeeById(int id) {
        boolean isRemoved = employees.removeIf(employees -> employees.getEmployee_id() == id);
        if (isRemoved) {
            System.out.println("Employee has been removed");
        } else
            System.out.println("Id provided does not match any existing employee");
    }


 /*
      method: displayEmployees
      parameters: None
      return: void
      purpose: displays all the current employees' information on the screen. If the
      list is empty, returns a corresponding message
     */

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("\nCurrently there are no employees in the system");
        } else {
            System.out.println("Employees in the system:");
            for (GymEmployee e : employees) {
                System.out.println(e);
            }
        }
    }

    /*
     method: updateRecord
     parameters: None
     return: void
     purpose: updates the fields of an employee inside the employees list, using the id and prompting
     the user to change one field at a time
    */
    public void updateRecord() {
        Scanner scanner = new Scanner(System.in);
        int id;

        System.out.println("Please input the Id of the record you wish to update: ");
        id = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        int choice;
        do {
            System.out.println("Make a selection: " +
                    "\n 1. Name" +
                    "\n 2. Last Name" +
                    "\n 3. Job Title" +
                    "\n 4. Hourly Wage" +
                    "\n 5. Date Enrolled" +
                    "\n 6. Stop");
            System.out.println("Please input the number associated with the attribute you wish to update: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Please input the new name: ");
                    String newName = scanner.nextLine();
                    for (GymEmployee e : employees) {
                        if (e.getEmployee_id() == id) {
                            e.setEmployee_name(newName);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Please input the new last name: ");
                    String newLastName = scanner.nextLine();
                    for (GymEmployee e : employees) {
                        if (e.getEmployee_id() == id) {
                            e.setEmployee_last_name(newLastName);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Please input the new job title: ");
                    String newJobTitle = scanner.nextLine();
                    for (GymEmployee e : employees) {
                        if (e.getEmployee_id() == id) {
                            e.setJob_title(newJobTitle);
                        }
                    }
                    break;

                case 4:
                    try{
                    System.out.println("Please input the new hourly wage: ");
                    double newHourlyWage = scanner.nextDouble();
                    scanner.nextLine();  // Consume the leftover newline
                        if (newHourlyWage < 12.00 || newHourlyWage > 40.00) {
                            throw new InvalidHourlyWageException("The Hourly Wage must be between $12.00 and $40.00");
                        }
                        for (GymEmployee e : employees) {
                            if (e.getEmployee_id() == id) {
                                e.setHourly_wage(newHourlyWage);
                            }
                        }
                    }catch (InvalidHourlyWageException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Please input the new Date Enrolled: ");
                        String newDateEnrolled = scanner.nextLine();
                        // Validate the date input format
                        if (!newDateEnrolled.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            throw new InvalidDateException("The date must be formatted as YYYY-MM-DD");
                        }
                        for (GymEmployee e : employees) {
                            if (e.getEmployee_id() == id) {
                                e.setDate_enrolled(newDateEnrolled);
                            }
                        }
                    }catch (InvalidDateException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting update process.");
                    break;

                default:
                    System.out.println("Wrong choice. Try again.");
            }

        } while (choice != 6);
    }


    /*
     method: displayAvgWage(custom action)
     parameters: None
     return: double
     purpose: displays the average of all the employee wages
    */
    public double displayAvgWage() {
        double avg = 0;
        double count = 0;
        if (employees.isEmpty()) {
            avg=-1;
        } else {
            for (GymEmployee e : employees) {
                count += e.getHourly_wage();
            }
            avg = count / employees.toArray().length;

        }
        return avg;
    }
    /*
          method: displayMenu
          parameters: None
          return: void
          purpose: displays the GMS menu
         */
    public void displayMenu() {
        System.out.println( "\n1. Add employee from a file"+
                "\n2. Add employee manually" +
                "\n3. Remove employee using ID number"+
                "\n4. Update Record"+
                "\n5. Display average wage"+
                "\n6. Exit"+
                "\nEnter a number to start: ");
    }
}

