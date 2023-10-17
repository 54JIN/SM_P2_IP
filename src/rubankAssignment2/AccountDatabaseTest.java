// package rubankAssignment2;

import static org.junit.jupiter.api.Assertions.*;

class AccountDatabaseTest {

    /**
     * Tests an invalid date that has day > 31
     */
    @org.junit.jupiter.api.Test
    void validClose()
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

        AccountDatabase database = new AccountDatabase();
        database.open(s1);
        database.close(s1);
    }
    /**
     * Tests an invalid date that has day > 31
     */
    @org.junit.jupiter.api.Test
    void invalidClose()
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

        AccountDatabase database = new AccountDatabase();
        database.open(s1);
        database.close(s2);
    }
}