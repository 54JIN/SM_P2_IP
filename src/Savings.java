import java.text.DecimalFormat;

/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class Savings extends Account
{
    private static final double INTERESTRATE = 0.0033;
    private static final double HIGHERINTERESTRATE = 0.00354;
    private static final double MONTHLYFEE = 25.00;
    private static final double NOMONTHLYFEE = 0.00;
    private static final double NOMONTHLYFEEBALANCE = 500.00;
    protected boolean isLoyal; //loyal customer status

    /**
     * Constructor for Savings object, calls super() to use Account's constructor and declares loyalty status.
     * @param person Profile of a person with fname, lname, and dob
     * @param balance Account balance of the person
     * @param loyalty Boolean value representing if the person is a loyal customer or not
     */
    public Savings(Profile person, double balance, int loyalty)
    {
        super(person, balance);
        this.isLoyal = (loyalty == 1);


    }

    /**
     * Overrides abstract method monthlyInterest from Account
     * @return interest rate for the person's Savings account
     */
    @Override
    public double monthlyInterest() {
        if(isLoyal)
        {
            return HIGHERINTERESTRATE * this.balance;
        }
        return INTERESTRATE * this.balance;
    }

    /**
     * Overrides abstract method monthlyFee from Account
     * @return monthly fee for Savings accounts
     */
    @Override
    public double monthlyFee() {
        if(balance > NOMONTHLYFEEBALANCE)
        {
            return NOMONTHLYFEE;
        }
        return MONTHLYFEE;
    }

    /**
     * Overrides toString for a Savings account
     * @return String form including the holder's profile information, balance, and loyalty status
     */
    @Override
    public String toString()
    {
        DecimalFormat currency= new DecimalFormat("$ #,##0.00");
        String loyalString;
        if(isLoyal)
        {
            loyalString = "is loyal";
        }
        else
        {
            loyalString = "is not loyal";
        }

        return ("Savings::" + this.holder.toString() + "::Balance " + currency.format(this.balance) + "::" +
                loyalString);
    }

    /**
     * Compares two Savings accounts; calls super().compareTo if the objects are not both Savings
     * @param otherAccount the account to be compared.
     * @return 0 if accounts are equal and Savings accounts; -1 or 1 if both accounts are Savings accounts but not equal; or an integer {-3 to 3} to help represent the accounts in alphabetical order.
     */
    @Override
    public int compareTo(Account otherAccount)
    {
        if(super.compareTo(otherAccount) == 0) //if balance and profile is same, check if both are Savings accounts
        {
            if(otherAccount instanceof Savings)
            {
                Savings otherSavings = (Savings) otherAccount;
                return Boolean.compare(this.isLoyal, otherSavings.isLoyal);
            }
        }
        //If balance and profile are not equal return account compareTo method
            return super.compareTo(otherAccount);
    }

    /**
     * Checks if two Savings accounts are equal
     * @param s Savings account to compare against
     * @return true if both accounts are the same, false if not
     */
    public boolean equals(Savings s)
    {
        return this.compareTo(s) == 0;
    }
}
