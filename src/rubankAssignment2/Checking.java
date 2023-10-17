// package rubankAssignment2;

import java.text.DecimalFormat;

/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class Checking extends Account
{

    private static final double INTERESTRATE = 0.00083;
    private static final double MONTHLYFEE = 12.00;
    private static final double NOMONTHLYFEE = 0.00;
    private static final double NOMONTHLYFEEBALANCE = 1000.00;

    /**
     * Calls super() to use Account's constructor since there's no new instance variables.
     * @param person Profile of a person with fname, lname, and dob
     * @param bal Account balance of the person
     */
    public Checking(Profile person, double bal)
    {
        super(person, bal);
    }


    /**
     * Overrides abstract method monthlyInterest from Account
     * @return interest rate for the person's Checking account
     */
    @Override
    public double monthlyInterest()
    {
        return INTERESTRATE * this.balance;
    }

    /**
     * Overrides abstract method monthlyFee from Account
     * @return monthly fee for Checking accounts
     */
    @Override
    public double monthlyFee() {
        if (balance > NOMONTHLYFEEBALANCE)
        {
           return NOMONTHLYFEE;
        }
        return MONTHLYFEE;
    }

    /**
     * Overrides toString for a Checking account
     * @return String form including the holder's profile information and their balance
     */
    @Override
    public String toString()
    {
        DecimalFormat currency= new DecimalFormat("$#,##0.00");

        return ("Checking::" + this.holder.toString() + "::Balance " + currency.format(this.balance));
    }

    /**
     * Checks if two Checking accounts are equal
     * @param c Checking account to compare against
     * @return true if both accounts are the same, false if not
     */
    public boolean equals(Checking c)
    {
        if(this.holder.equals(c.holder))
        {
            return true;
        }
        return this.compareTo(c) == 0;
    }

}
