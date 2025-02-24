/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  February 24, 2025
  GymEmployee.java
  Class that will create the GymEmployee Objects
 */
public class GymEmployee {
    private int employee_id;
    private String employee_name;
    private String employee_last_name;
    private String job_title;
    private double hourly_wage;
    private String date_enrolled;

    /*
     method: GymEmployee
     parameters: int employee_id, String employee_name, String employee_last_name,
     String job_title, double hourly_wage, String date_enrolled
     return: -
     purpose: Constructor method, creates a GymEmployee object
    */
    public GymEmployee(int employee_id, String employee_name, String employee_last_name, String job_title, double hourly_wage, String date_enrolled) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_last_name = employee_last_name;
        this.job_title = job_title;
        this.hourly_wage = hourly_wage;
        this.date_enrolled = date_enrolled;
    }

    //Getters and setters
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public double getHourly_wage() {
        return hourly_wage;
    }

    public void setHourly_wage(double hourly_wage) {
        this.hourly_wage = hourly_wage;
    }

    public String getDate_enrolled() {
        return date_enrolled;
    }

    public void setDate_enrolled(String date_enrolled) {
        this.date_enrolled = date_enrolled;
    }

    /*
      method: toString
      parameters: None
      return: String
      purpose: prints the details of the GymEmployee object
     */
    @Override
    public String toString() {
        return "{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_last_name='" + employee_last_name + '\'' +
                ", job_title='" + job_title + '\'' +
                ", hourly_wage=" + String.format("%.2f", hourly_wage) +
                ", date_enrolled='" + date_enrolled + '\'' +
                '}';
    }
}
