package rubankAssignment2;

import java.text.DecimalFormat;

public class TestertoDelete
{
    public static void main(String[] args)
    {
        Profile p1 = new Profile ("Jane", "Doe", "2/19/2000");
        Profile p2 = new Profile ("John", "Doe", "2/19/2000");
        Profile p3 = new Profile ("george", "carlos", "9/16/2016");

        MoneyMarket mm1 = new MoneyMarket(p1, 7.13,  1);
        MoneyMarket mm2 = new MoneyMarket(p1, 200000,  1);
        MoneyMarket mm3 = new MoneyMarket(p2, 300000,  1);
        Savings s1 = new Savings(p1, 200000, 1);
        Savings s2 = new Savings(p1, 200000, 0);
        Savings s3 = new Savings(p1, 200000, 1);
        CollegeChecking cc1 = new CollegeChecking(p2, 200000, Campus.CAMDEN);
        Checking c1 = new Checking(p2, 599.99);

        /*System.out.println(p1.compareTo(p2)); //should be lesser


        System.out.println(mm1.compareTo(mm2)); //equal
        System.out.println(s1.compareTo(mm2)); //diff classes
        System.out.println(s1.compareTo(s2)); //diff loyalty
        System.out.println(s1.compareTo(s3)); //equal
        System.out.println(s1.compareTo(mm3)); //diff classes, -1
        System.out.println(cc1.compareTo(s1)); //diff classes, +2
        System.out.println(cc1.compareTo(c1)); //diff classes, -1
        System.out.println(c1.compareTo(s1)); //diff classes, +3

        Account[] accounts = {mm1, s1, c1, cc1, c1};
        //Should print as Checking,Checking,CollegeChecking,MoneyMarket,Savings,Savings
        Account[] sorted = sortByAccountType(accounts);
        for(int i = 0; i < sorted.length; i++)
        {
            System.out.println(sorted[i].getClass());
        }
        System.out.println(containsTest(mm1, accounts)); //true
        System.out.println(containsTest(c1, accounts)); //true
        System.out.println(containsTest(cc1, accounts)); //false

        System.out.println(mm1.equals(s1));
        System.out.println(mm1.equals(s2));
        System.out.println(cc1);
        System.out.println(c1);
        System.out.println(mm1);
        System.out.println(s1);

        DecimalFormat currency= new DecimalFormat("$#,##0.00");
        System.out.println(c1.monthlyInterest());
        System.out.println(currency.format(c1.monthlyInterest()));

        System.out.println(c1.equals(cc1));
        System.out.println(p1.equals(p3));*/

        AccountDatabase database = new AccountDatabase();
        database.open(s1);
        database.open(mm1);
        database.open(mm3);
        database.printSorted();
        database.printFeesAndInterests();
        database.printUpdatedBalance();
        database.printFeesAndInterests();
        System.out.println(database.close(mm1));
        database.printSorted();
        System.out.println(p1.compareTo(p2));
        database.open(c1);
        System.out.println(database.contains(cc1));
        System.out.println(cc1.equals(c1));
        System.out.println(p2.equals(p2));

    }
    private static Account[] sortByAccountType(Account[] accounts) {
        Account[] temp = new Account[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                temp[i] = accounts[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                Account tempE = null;
                if (temp[i] != null && temp[j] != null && temp[i].compareTo(temp[j]) < 0) {
                    tempE = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tempE;
                }
            }
        }
        return temp;
    }
    private static boolean containsTest(Account account, Account[] accounts)//overload if necessary
    {
        for(int i = 0; i < accounts.length; i++)
        {
            if(accounts[i] != null && accounts[i].equals(account))
            {
                return true;
            }
        }
        return false;
    }
}
