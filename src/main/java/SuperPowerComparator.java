import java.util.Comparator;

public class SuperPowerComparator implements Comparator<Superhero>
{
    public int compare(Superhero s1, Superhero s2)
    {
        return s1.getSuperPowers().compareTo(s2.getSuperPowers());
    }
}