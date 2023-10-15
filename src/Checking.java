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

    public Checking(Profile person, double bal)
    {
        super(person, bal);
    }

    @Override
    public double monthlyInterest()
    {
        return INTERESTRATE;
    }

    @Override
    public double monthlyFee() {
        if (balance > NOMONTHLYFEEBALANCE)
        {
           return NOMONTHLYFEE;
        }
        return MONTHLYFEE;
    }

    @Override
    public String toString()
    {
        DecimalFormat currency= new DecimalFormat("$ #,##0.00");

        return ("Checking::" + this.holder.toString() + "::Balance " + currency.format(this.balance));
    }

    public boolean equals(Checking c)
    {
        return this.compareTo(c) == 0;
    }

}
