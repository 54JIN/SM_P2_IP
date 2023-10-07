import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    /**
     * Tests an invalid date that has day > 31
     */
    @org.junit.jupiter.api.Test
    void invalidDayTest()
    {
        Date d = new Date("10/32/2023");
        assertFalse(d.isValid());
    }
    /**
     * Tests an invalid date that has day < 1
     */
    @org.junit.jupiter.api.Test
    void invalidDayTest2()
    {
        Date d = new Date("10/0/2023");
        assertFalse(d.isValid());
    }
    /**
     * Tests an invalid month with month > 12
     */
    @org.junit.jupiter.api.Test
    void invalidMonthTest1()
    {
        Date d = new Date("13/30/2023");
        assertFalse(d.isValid());
    }
    /**
     * Tests an invalid month with month < 1
     */
    @org.junit.jupiter.api.Test
    void invalidMonthTest2()
    {
        Date d = new Date("0/30/2023");
        assertFalse(d.isValid());
    }
    /**
     * Tests a valid date on a leap year
     */
    @org.junit.jupiter.api.Test
    void leapYearTest()
    {
        Date d = new Date("2/29/2016");
        assertTrue(d.isValid());
    }
    /**
     * Tests an invalid date on a non leap year
     */
    @org.junit.jupiter.api.Test
    void notLeapYearTest()
    {
        Date d = new Date("2/29/2017");
        assertFalse(d.isValid());
    }
    /**
     * Tests day = 31 on a month that doesn't have 31 days
     */
    @org.junit.jupiter.api.Test
    void notThirtyOneDaysInMonthTest()
    {
        Date d = new Date("11/31/2017");
        assertFalse(d.isValid());
    }
    /**
     * Tests an invalid date of day > 29 in February on a leap year
     */
    @org.junit.jupiter.api.Test
    void greaterThan29DaysInFebruary()
    {
        Date d = new Date("2/30/2016");
        assertFalse(d.isValid());
    }
    /**
     * Tests day = 31 on a month that has 31 days
     */
    @org.junit.jupiter.api.Test
    void thirtyOneDaysInMonthTest()
    {
        Date d = new Date("1/31/2017");
        assertTrue(d.isValid());
    }
    /**
     * Tests an invalid year given year < 1900 is invalid
     */
    @org.junit.jupiter.api.Test
    void invalidYearTest()
    {
        Date d = new Date("1/31/1899");
        assertFalse(d.isValid());
    }
    /**
     * Tests an invalid year given someone's birthdate cannot be in the future
     */
    @org.junit.jupiter.api.Test
    void futureDOBTest()
    {
        Date d = new Date("10/7/2023");
        assertFalse(d.isValid());
    }
    /**
     * Tests a valid year given someone's birthdate can be exactly today
     */
    @org.junit.jupiter.api.Test
    void currentDayTest()
    {
        Date d = new Date("10/6/2023");
        assertTrue(d.isValid());
    }

}