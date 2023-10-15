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
    @Override
    public int compareTo(Account otherAccount)
    {
        int profileComparison = this.holder.compareTo(otherAccount.holder);

        if(this.getClass() != otherAccount.getClass()) //If classes are not the same return -2 (change later to -1)
        {
            if(this.getClass() == Savings.class || otherAccount.getClass() == Savings.class)
            {
                if(this.getClass() == Savings.class)
                {
                    if(otherAccount.getClass() == MoneyMarket.class)
                    {
                        return -1;
                    }
                    if(otherAccount.getClass() == CollegeChecking.class)
                    {
                        return -2;
                    }
                    if(otherAccount.getClass() == Checking.class)
                    {
                        return -3;
                    }
                }
                if(otherAccount.getClass() == Savings.class)
                {
                    if(this.getClass() == MoneyMarket.class)
                    {
                        return 1;
                    }
                    if(this.getClass() == CollegeChecking.class)
                    {
                        return 2;
                    }
                    if(this.getClass() == Checking.class)
                    {
                        return 3;
                    }
                }
            }
            if(this.getClass() == MoneyMarket.class || otherAccount.getClass() == MoneyMarket.class)
            {
                if(this.getClass() == MoneyMarket.class)
                {
                    if(otherAccount.getClass() == CollegeChecking.class)
                    {
                        return -1;
                    }
                    if(otherAccount.getClass() == Checking.class)
                    {
                        return -2;
                    }
                }
                if(otherAccount.getClass() == MoneyMarket.class)
                {
                    if(this.getClass() == CollegeChecking.class)
                    {
                        return 1;
                    }
                    if(this.getClass() == Checking.class)
                    {
                        return 2;
                    }
                }
            }
            if(this.getClass() == CollegeChecking.class || otherAccount.getClass() == CollegeChecking.class)
                {
                    if(this.getClass() == CollegeChecking.class)
                    {
                        if(otherAccount.getClass() == Checking.class)
                        {
                            return -1;
                        }
                    }
                    if(otherAccount.getClass() == CollegeChecking.class)
                    {
                        if(this.getClass() == Checking.class)
                        {
                            return 1;
                        }
                    }
                }
        }
        if(profileComparison == 0) //if profile matches, compare by balance
        {
            return Double.compare(this.balance, otherAccount.balance);
        }
        return profileComparison;
    }

    public boolean equals(Account acc)
    {
        return this.compareTo(acc) == 0;
    }







}
