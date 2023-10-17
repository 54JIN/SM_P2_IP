package rubankAssignment2;

import java.text.DecimalFormat;
/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class MoneyMarket extends Savings
{
    private int withdrawal; //number of withdrawals
    private static final double INTERESTRATE = 0.00375;
    private static final double HIGHERINTERESTRATE = 0.00395;
    private static final double MONTHLYFEE = 25.00;
    private static final double NOMONTHLYFEE = 0.00;
    private static final double WITHDRAWALTAX = 10.00;
    private static final double NOMONTHLYFEEBALANCE = 2000.00;
    private static final int TOOMANYWITHDRAWALS = 3;

    /**
     * Constructor for MoneyMarket object, calls super() to use Savings' constructor and declares amount of withdrawals.
     * @param person Profile of a person with fname, lname, and dob
     * @param balance Account balance of the person
     * @param withdrawals Amount of withdrawals the person has done on this account
     */
    public MoneyMarket(Profile person, double balance, int withdrawals) //may have to remove loyalty!!!
    {
        super(person, balance, 1);
        this.withdrawal = withdrawals;
    }

    /**
     * Overrides method monthlyInterest from Savings
     * @return interest rate for the person's Money Market account
     */
    @Override
    public double monthlyInterest()
    {
        if(this.isLoyal)
        {
            return HIGHERINTERESTRATE * this.balance;
        }
        return INTERESTRATE * this.balance;

    }
    /**
     * Overrides method monthlyFee from Savings
     * @return monthly fee for Money Market accounts
     */
    @Override
    public double monthlyFee()
    {
        if (balance > NOMONTHLYFEEBALANCE)
        {
            return NOMONTHLYFEE;
        }
        if(withdrawal > TOOMANYWITHDRAWALS)
        {

            return (MONTHLYFEE + WITHDRAWALTAX);
        }
        return MONTHLYFEE;
    }

    /**
     * Compares two Money Market accounts; calls super().compareTo if the objects are not both Money Market
     * @param otherAccount the account to be compared.
     * @return 0 if accounts are equal and Money Market accounts; -1 or 1 if both accounts are Money Market accounts but not equal; or an integer {-3 to 3} to help represent the accounts in alphabetical order.
     */
    @Override
    public int compareTo(Account otherAccount)
    {
        if(super.compareTo(otherAccount) == 0) //Is a savings account and equal
        {
            if(otherAccount instanceof MoneyMarket) //is a MoneyMarket account
            {
                MoneyMarket otherMoneyMarket = (MoneyMarket) otherAccount;
                return Integer.compare(this.withdrawal, otherMoneyMarket.withdrawal);
            }
        }
        return super.compareTo(otherAccount);
    }
    public void resetWithdrawals()
    {
        this.withdrawal = 0;
    }
    public void addWithdrawals()
    {
        this.withdrawal++;
    }
    public void removeLoyalty()
    {
        this.isLoyal = false;
    }
    public void addLoyalty()
    {
        this.isLoyal = true;
    }

    /**
     * Overrides toString for a Money Market account
     * @return String form including the holder's profile information, balance, loyalty status, and number of withdrawals
     */
    @Override
    public String toString() //CHANGE MM TOSTRING TO NOT HAVE ANYTHING WHEN USER IS NOT LOYAL
    {
        DecimalFormat currency= new DecimalFormat("$#,##0.00");
        String loyalString;
        if(isLoyal)
        {
            loyalString = "is loyal";
        }
        else
        {
            loyalString = "";
        }

        return ("Money Market::Savings::" + this.holder.toString() + "::Balance " + currency.format(this.balance) + "::" +
                loyalString + "::withdrawal: " + withdrawal);
    }

    /**
     * Checks if two Money Market accounts are equal
     * @param mm Money Market account to compare against
     * @return true if both accounts are the same, false if not
     */
    public boolean equals(MoneyMarket mm)
    {
        return this.compareTo(mm) == 0;
    }
}
