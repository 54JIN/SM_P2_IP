/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    /**
     * Constructor for a profile that will represent a person's identity with their full name and dob
     * @param fname person's first name
     * @param lname person's last name
     * @param dob person's date of birth
     */
    public Profile(String fname, String lname, String dob)
    {
        this.fname = fname;
        this.lname = lname;
        this.dob = new Date(dob);
    }

    /**
     * Comparison method to check if two profiles are the same or not.
     * @param profile the profile to be compared.
     * @return 0 if people have the same name and dob, -1 or 1 if they do not.
     */
    @Override
    public int compareTo(Profile profile)
    {
        int dateComparison = this.dob.compareTo(profile.dob);
        String fullName1 = this.fname + " " + this.lname; //combine into full names
        String fullName2 = profile.fname + " " + profile.lname;
        int nameComparison = fullName1.compareTo(fullName2);

        if(nameComparison == 0) //if names are the same, compare by dob
        {
            return dateComparison;
        }
        return nameComparison;

    }

    /**
     * Checks if two profiles are equal
     * @param profile profile to compare against
     * @return true if both profiles are the same, false if not
     */
   public boolean equals(Profile profile)
    {
        return (this.fname.equals(profile.fname) && this.lname.equals(profile.lname)
                && this.dob.equals(profile.dob));
    }

    /**
     * Overrides toString for a profile
     * @return String form including the holder's name and dob
     */
    @Override
    public String toString()
    {
        return (fname +  " " + lname + " " + dob.toString());
    }

  /*  public static void main (String[] args)
    {
        Profile p1 = new Profile("John Doe", "Johnson", "9/29/2003");
        Profile p2 = new Profile("Jane Doe", "Johnson", "9/29/2003");
        System.out.println(p1.compareTo(p2));
    }*/
}
