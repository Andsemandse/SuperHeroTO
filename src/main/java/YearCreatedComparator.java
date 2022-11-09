import Shero.Superhero;

import java.util.Comparator;

public class YearCreatedComparator implements Comparator<Superhero>
{
    public int compare(Superhero s1, Superhero s2)
    {
        return Integer.compare(s1.getYearCreated(), s2.getYearCreated());
    }
}