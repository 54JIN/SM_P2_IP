/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    public Profile(String fname, String lname, String dob)
    {
        this.fname = fname;
        this.lname = lname;
        this.dob = new Date(dob);
    }
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

   /* public boolean equals(Profile profile)
    {
        return (this.fname.equals(profile.fname) && this.lname.equals(profile.lname)
                && this.dob.equals(profile.dob));
    }*/

  /*  public static void main (String[] args)
    {
        Profile p1 = new Profile("John Doe", "Johnson", "9/29/2003");
        Profile p2 = new Profile("Jane Doe", "Johnson", "9/29/2003");
        System.out.println(p1.compareTo(p2));
    }*/
}
