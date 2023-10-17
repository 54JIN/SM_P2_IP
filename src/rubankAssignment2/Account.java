package rubankAssignment2;

/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public abstract class Account implements Comparable<Account>
{
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    public abstract String toString();

    /**
     * Base constructor for an account object to be called by subclasses
     * @param person Profile of a person with fname, lname, and dob
     * @param balance Account balance of the person
     */
    public Account(Profile person, double balance)
    {
        this.holder = person;
        this.balance = balance;
    }
    /*
                 C > CC > MM > S
                 Comparisons:
                     savings to cc = -2
                     savings to mm = -1
                     savings to c = -3

                     cc to savings = 2
                     cc to mm = 1
                     cc to c = -1

                     mm to savings = 1
                     mm to cc = -1
                     mm to c = -2

                     c to savings = 3
                     c to mm = 2
                     c to cc = 1
           */

    /**
     * Comparison method to be called by subclasses when comparing two accounts of unequal type
     * @param otherAccount the account to be compared.
     * @return 0 if accounts are equal; -1 or 1 if both accounts are the same type but not equal; or an integer {-3 to 3} to help represent the accounts in alphabetical order.
     */
    @Override
    public int compareTo(Account otherAccount)
    {
        int profileComparison = this.holder.compareTo(otherAccount.holder);

        if(this.getClass() != otherAccount.getClass()) //If classes are not the same return -2 (change later to -1)
        {
            if(this.getClass() == Savings.class || otherAccount.getClass() == Savings.class)
            {
               return savingsCheck(this, otherAccount);
            }
            if(this.getClass() == MoneyMarket.class || otherAccount.getClass() == MoneyMarket.class)
            {
                return moneyMarketCheck(this, otherAccount);
            }
            if(this.getClass() == CollegeChecking.class || otherAccount.getClass() == CollegeChecking.class)
                {
                    return collegeCheckingCheck(this, otherAccount);
                }
        }
        /*if(profileComparison == 0) //if profile matches, compare by balance
        {
            return Double.compare(this.balance, otherAccount.balance);
        }*/
        return profileComparison;
    }

    /**
     * Checks one collegeChecking Account against another account to help with sorting alphabetically.
     * @param acc Initial account to be compared
     * @param otherAccount Other account to be compared
     * @return -1 or 1 indicating the MoneyMarket account's relation to the other account alphabetically.
     */
    private int collegeCheckingCheck(Account acc, Account otherAccount)
    {
        if(acc.getClass() == CollegeChecking.class)
        {
            if(otherAccount.getClass() == Checking.class)
            {
                return 1;
            }
        }
        if(otherAccount.getClass() == CollegeChecking.class)
        {
            if(acc.getClass() == Checking.class)
            {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Checks one moneyMarket Account against another account to help with sorting alphabetically.
     * @param acc Initial account to be compared
     * @param otherAccount Other account to be compared
     * @return Integer from {-2-2 excluding 0} indicating the MoneyMarket account's relation to the other account alphabetically.
     */
    private int moneyMarketCheck(Account acc, Account otherAccount)
    {
        if(acc.getClass() == MoneyMarket.class)
        {
            if(otherAccount.getClass() == CollegeChecking.class)
            {
                return 1;
            }
            if(otherAccount.getClass() == Checking.class)
            {
                return 2;
            }
        }
        if(otherAccount.getClass() == MoneyMarket.class)
        {
            if(acc.getClass() == CollegeChecking.class)
            {
                return -1;
            }
            if(acc.getClass() == Checking.class)
            {
                return -2;
            }
        }
        return 0; //GRAVE ERROR HAS OCCURRED TO REACH HERE!
    }

    /**
     * Checks one Savings Account against another account to help with sorting alphabetically.
     * @param acc Initial account to be compared
     * @param otherAccount Other account to be compared
     * @return Integer from {-3-3 excluding 0} indicating the Savings account's relation to the other account alphabetically.
     */
    private int savingsCheck(Account acc, Account otherAccount)
    {
        if(acc.getClass() == Savings.class)
        {
            if(otherAccount.getClass() == MoneyMarket.class)
            {
                return 1;
            }
            if(otherAccount.getClass() == CollegeChecking.class)
            {
                return 2;
            }
            if(otherAccount.getClass() == Checking.class)
            {
                return 3;
            }
        }
        if(otherAccount.getClass() == Savings.class)
        {
            if(acc.getClass() == MoneyMarket.class)
            {
                return -1;
            }
            if(acc.getClass() == CollegeChecking.class)
            {
                return -2;
            }
            if(acc.getClass() == Checking.class)
            {
                return -3;
            }
        }
        return 0; //GRAVE ERROR HAS OCCURRED TO REACH HERE
    }

    /**
     * Checks if two Account classes are equal
     * @param acc Account to compare against
     * @return true if both accounts are the same, false if not
     */
    public boolean equals(Account acc)
    {
        return this.compareTo(acc) == 0;
    }

}
