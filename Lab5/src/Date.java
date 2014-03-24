// CS 2510 Lab 5
import tester.*;

// to represent a calendar date
public class Date {
  int year;
  int month;
  int day;

  /*Date(int year, int month, int day){
    this.year = year;
    this.month = month;
    this.day = day; 
  }
  */
  
  //takes in year, month, and day, no constants
  Date(int year, int month, int day){
      if(this.validYear(year))
         this.year = year;
      else
         throw new IllegalArgumentException("Invalid year: " + year);
    
      if(this.validMonth(month))
         this.month = month;
      else
         throw new IllegalArgumentException("Invalid month: " + month);
    
      if(this.validDay(day))
         this.day = day;
      else
         throw new IllegalArgumentException("Invalid day: " + day);
  }
  
  //new constructor only takes in month and day, gives a constant year
  Date(int month, int day) {
      this(2013, month, day);
  }
  
  //new constructor takes in string as a month, then day, then year
  Date(String month, int day, int year) {
      this(day, year);
      this.month = this.getMonthNo(month);
  }
  
  //validNumber
  public boolean validNumber(int num, int low, int high) {
      return (num >= low) && (num <= high);
  }
  
  //validDay
  public boolean validDay(int d) {
      return (this.validNumber(d, 1, 31));
  }
  
  //validMonth
  public boolean validMonth(int m) {
      return (this.validNumber(m,  1,  12));
  }
  
  //validYear
  public boolean validYear(int y) {
      return (this.validNumber(y, 1, 10000));
  }
  

  //Convert a three letter month into the numeric value
  int getMonthNo(String month){
      if(month.equals("Jan")){ return 1; }
      else if (month.equals("Feb")){ return 2; }
      else if (month.equals("Mar")){ return 3; }
      else if (month.equals("Apr")){ return 4; }
      else if (month.equals("May")){ return 5; }
      else if (month.equals("Jun")){ return 6; }
      else if (month.equals("Jul")){ return 7; }
      else if (month.equals("Aug")){ return 8; }
      else if (month.equals("Sep")){ return 9; }
      else if (month.equals("Oct")){ return 10; }
      else if (month.equals("Nov")){ return 11; }
      else if (month.equals("Dec")){ return 12; }
      else
          throw new IllegalArgumentException("Invalid month");
  }

}