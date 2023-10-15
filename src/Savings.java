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

    public Savings(Profile person, double balance, int loyalty)
    {
        super(person, balance);
        this.isLoyal = (loyalty == 1);


    }
    @Override
    public double monthlyInterest() {
        if(isLoyal)
        {
            return HIGHERINTERESTRATE;
        }
        return INTERESTRATE;
    }

    @Override
    public double monthlyFee() {
        if(balance > NOMONTHLYFEEBALANCE)
        {
            return NOMONTHLYFEE;
        }
        return MONTHLYFEE;
    }

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

    public boolean equals(Savings s)
    {
        return this.compareTo(s) == 0;
    }
}
