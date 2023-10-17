// package rubankAssignment2;

import java.util.Calendar;
/**
 * Creates Date with year, month, and day and provides method isValid() to check if the date is valid
 * @author Vivek Bhadkamkar (@vab85)
 * @author Sajin Saju (@ss3652)
 */
public class Date implements Comparable<Date>
{
    /**
     * Year
     */
    private int year;
    /**
     * Month
     */
    private int month;
    /**
     * Day
     */
    private int day;

    //Define constants to be used for isValid()
    /**
     * QUADRENNIAL assignment for isLeapYear
     */
    public static final int QUADRENNIAL = 4;
    /**
     * CENTENNIAL assignment for isLeapYear
     */
    public static final int CENTENNIAL = 100;
    /**
     * QUARTERCENTENNIAL assignment for isLeapYear
     */
    public static final int QUARTERCENTENNIAL = 400;
    /**
     * Define months with 31 days as a REGMONTH
     */
    public static final int[] REGMONTH = {1,3,5,7,8,10,12}; //A month with 31 days is a REGMONTH
    /**
     * Define the length of a REGMONTH as 31 (days)
     */
    public static final int REGMONTHLENGTH = 31;
    /**
     * Define the number of months in a year
     */
    public static final int NUMMONTHSINYEAR = 12;
    /**
     * Define the number of months in February
     */
    public static final int LEAPYEARFEBRUARY = 29;
    /**
     * Define integer value for February
     */
    public static final int FEBRUARY = 2;
    /**
     * Create calendar object to check the current date
     */
    /**
     * Constructor that creates a date object from year, month, and day
     * @param month Month in Year
     * @param day Day of the month
     * @param year Year
     */
    public Date(int month, int day, int year) //Constructor for testing expected outputs
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Constructor that creates a date object from a string
     * @param dateString String for parsing a string input of Date.
     */
    public Date(String dateString) //Constructor that parses from date format (Ex. 9/20/2023) to obtain month, day, and year.
    {
        String[] dateTokens = dateString.split("/");
        this.month = Integer.parseInt(dateTokens[0]);
        this.day = Integer.parseInt(dateTokens[1]);
        this.year = Integer.parseInt(dateTokens[2]);
        //System.out.println(this.month + "/" + this.day + "/" + this.year); //Check if it gets the correct values.

    }


    /**
     * Checks if a given date is valid
     * @return true or false depending on whether the date is valid or not.
     */
    public boolean isValid()
    {
            boolean isLeapYear = isLeapYear(this.year);
            boolean isRegMonth = isRegMonth(this.month);
            Calendar today = Calendar.getInstance();
        // check invalid year, check invalid month, check invalid day, check invalid day in february,

            if(this.day > REGMONTHLENGTH || this.month > NUMMONTHSINYEAR || this.month <= 0 || this.day <= 0 || this.year < 1900) //Check if invalid date at all
            {
                return false;
            }
            else if(this.year > today.get(Calendar.YEAR) || (this.year == today.get(Calendar.YEAR) && this.month > ((today.get(Calendar.MONTH) + 1) + 1)) || (this.year == today.get(Calendar.YEAR) && this.month == (today.get(Calendar.MONTH) + 1) && this.day >= today.get(Calendar.DAY_OF_MONTH)))
            {
                    return false;
            }
            else if(this.month == FEBRUARY) //Check February specifically
            {
                if(isLeapYear && this.day == LEAPYEARFEBRUARY)
                {
                    return true;
                }
                else if(!isLeapYear && this.day == LEAPYEARFEBRUARY)
                {
                    return false;
                }
                else if(this.day > LEAPYEARFEBRUARY)
                {
                    return false;
                }
                else return true;
            }
            else if (this.day == REGMONTHLENGTH) //Check for 31 day months
            {
                if(!isRegMonth)
                {return false;}
                else
                {return true;}
            }
            else
            {return true;}
    }


    /**
     * Checks if a month has 31 days or not
     * @param month Month to be checked if it has 31 days or not
     * @return true if Jan, Mar, May, July, Aug, Oct, or Dec; false otherwise
     */
    private boolean isRegMonth(int month)
    {
        for(int element : REGMONTH)
        {
            if(element == month)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if a year is a leap year or not
     * @param year Enter year to check if this year is a leap year or not.
     * @return true or false depending on whether it's a leap year or not.
     */
    private boolean isLeapYear(int year)
    {
        if(year % QUADRENNIAL == 0)
        {
            if(year % CENTENNIAL == 0)
            {
                if(year % QUARTERCENTENNIAL == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    /**
     * Compares two dates to see which one happens earlier and which one happens later
     * @param date The date to be compared to
     * @return 1 if this.date is later, 0 if they are on the same date, -1 if  this.date is earlier
     */
    @Override
    public int compareTo(Date date) {
        if(this.year > date.year) return 1;
        else if (this.year < date.year) return -1;
        else
        {
            if(this.month > date.month) return 1;
            else if(this.month < date.month) return -1;
            else
            {
                if(this.day > date.day) return 1;
                else if(this.day < date.day) return -1;
                else return 0;
            }
        }
    }
    public boolean underAge(){
        Calendar today = Calendar.getInstance();
        if(today.get(Calendar.YEAR) - this.year > 16){
            return true;
        }
        if(today.get(Calendar.YEAR) - this.year == 16){
            if(this.month < (today.get(Calendar.MONTH) + 1)){
                return true;
            }
            else if(this.month == (today.get(Calendar.MONTH) + 1)){
                if(this.day <= today.get(Calendar.DAY_OF_MONTH)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean overAge(){
        Calendar today = Calendar.getInstance();
        if(today.get(Calendar.YEAR) - this.year > 24){
            return true;
        }
        if(today.get(Calendar.YEAR) - this.year == 24){
            if(this.month < (today.get(Calendar.MONTH) + 1)){
                return true;
            }
            else if(this.month == (today.get(Calendar.MONTH) + 1)){
                if(this.day <= today.get(Calendar.DAY_OF_MONTH)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Formats date values into a string
     * @return String form of the date.
     */
    @Override
    public String toString(){return (month + "/" + day + "/" + year);}


}
