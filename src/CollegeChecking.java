import java.text.DecimalFormat;

/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class CollegeChecking extends Checking
{
    private Campus campus; //campus code
    private static final double INTERESTRATE = 0.00083;
    private static final double NOMONTHLYFEE = 0.00;

    /**
     * Constructor for CollegeChecking object, calls super() to use Checking's constructor and declares enum campus.
     * @param person Profile of a person with fname, lname, and dob
     * @param bal Account balance of the person
     * @param campus enum representing one of 3 Rutgers campuses
     */
    public CollegeChecking(Profile person, double bal, Campus campus)
    {
        super(person, bal);
        this.campus = campus;
    }

    /**
     * Overrides method monthlyInterest from Checking
     * @return interest rate for the person's College Checking account
     */
    @Override
    public double monthlyInterest()
    {

        return INTERESTRATE * this.balance;
    }

    /**
     * Overrides method monthlyFee from Checking
     * @return monthly fee for College Checking accounts
     */
    @Override
    public double monthlyFee()
    {
        return NOMONTHLYFEE;
    }

    /**
     * Compares two College Checking accounts; calls super().compareTo if the objects are not both College Checking
     * @param otherAccount the account to be compared.
     * @return 0 if accounts are equal and Colleg Checking accounts; -1 or 1 if both accounts are College Checking accounts but not equal; or an integer {-3 to 3} to help represent the accounts in alphabetical order.
     */
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

    /**
     * Checks if two College Checking accounts are equal
     * @param cc College Checking account to compare against
     * @return true if both accounts are the same, false if not
     */
    public boolean equals(CollegeChecking cc)
    {
        return this.compareTo(cc) == 0;
    }

    /**
     * Overrides toString for a College Checking account
     * @return String form including the holder's profile information, balance, and campus location
     */
    @Override
    public String toString()
    {
        DecimalFormat currency= new DecimalFormat("$ #,##0.00");

        return ("College Checking::" + this.holder.toString() + "::Balance " + currency.format(this.balance) + "::" + this.campus);
    }


}
