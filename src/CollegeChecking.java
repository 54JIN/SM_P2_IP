/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class CollegeChecking extends Checking
{
    private Campus campus; //campus code
    private static final double INTERESTRATE = 0.00083;
    private static final double NOMONTHLYFEE = 0.00;

    public CollegeChecking(Profile person, double bal, Campus campus)
    {
        super(person, bal);
        this.campus = campus;
    }

    @Override
    public double monthlyInterest()
    {
        return INTERESTRATE;
    }

    @Override
    public double monthlyFee()
    {
        return NOMONTHLYFEE;
    }
    @Override
    public int compareTo(Account otherAccount)
    {
        if(super.compareTo(otherAccount) == 0)
        {
            if(otherAccount instanceof CollegeChecking)
            {
                CollegeChecking otherCollegeChecking = (CollegeChecking) otherAccount;
                return this.campus.compareTo(otherCollegeChecking.campus);
            }
        }
        return super.compareTo(otherAccount);
    }

    public boolean equals(CollegeChecking cc)
    {
        return this.compareTo(cc) == 0;
    }
}
