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

    public MoneyMarket(Profile person, double balance, boolean loyalty, int withdrawals) //may have to remove loyalty!!!
    {
        super(person, balance, 1);
        this.withdrawal = withdrawals;
    }


    @Override
    public double monthlyInterest()
    {
        if(this.isLoyal)
        {
            return HIGHERINTERESTRATE;
        }
        return INTERESTRATE;

    }

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
        return NOMONTHLYFEE;
    }

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

        return ("Money Market::Savings::" + this.holder.toString() + "::Balance " + currency.format(this.balance) + "::" +
                loyalString + "::withdrawal: " + withdrawal);
    }
    public boolean equals(MoneyMarket mm)
    {
        return this.compareTo(mm) == 0;
    }
}
