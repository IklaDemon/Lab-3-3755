package ru.itmo.ale.Characters;

import java.util.Objects;

import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;
import ru.itmo.ale.Locations.Location;

public final class TheKid extends Person
{
    protected boolean saidSecret;

    public TheKid (Location l)
    {
        super ("The Kid", l);
        this.saidSecret = false;
    }

    /*
     * fancy "move to", but it's not used because in
     * the story is not wwritten that the kid is
     * climbing in the roof
     */
    public void climbTo (Location r)
    {
        if (r.getName().equals("Roof"))
        {
            System.out.println (this.getName() + " climbed to " + r.getName());
            this.moveTo (r);
        }
        else
            System.out.println("Wrong location, should be Roof but is " + r.getName());
    }

    public boolean tellSecret()
    {
        if (this.saidSecret == false)
        {
            this.speaks("I was in the roof with Karlsson");
            this.saidSecret = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * The kid, depending if the food is helthy or not
     * should comment on it
     */
    @Override
    public boolean eats (Meal m)
    {
        if (m.isHealthy())
        {
            System.out.println(this.getName() + ": Ugh, I don't like this food");
            if (m instanceof CabbageRoll)
            {
                Meal cabbageLeaf = this.divideCabbageRoll ((CabbageRoll) m);
                this.throwUnderTable(cabbageLeaf);
            }

            return false;
        }
        else
        {
            System.out.println(this.getName() + " likes " + m.getName());
            return true;
        }
    }

    /*
     * method to throw food nuder the table, if the food is not of the liking of the kid,
     * the method "eats ()" will automatically call this method
     */
    public void throwUnderTable (Meal meal)
    {
        DiningRoom dr;
        if (this.getCurrentLocation() instanceof DiningRoom)
        {
            dr = (DiningRoom) this.getCurrentLocation();
            dr.getTable().throwMealUnderTheTable(meal);
            System.out.println(this.getName() + " throws under the table " + meal.getName());
        }
        else
        {
            System.out.println("cant throw under the table, " + this.getName() + " is not in the dinigRoom");
        }
    }

    @Override
    public String toString ()
    {
        return super.toString() + "\nKid said secret: " + this.saidSecret;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof TheKid)) return false;
        if (!super.equals(obj)) return false;
        TheKid ch = (TheKid) obj;
        return this.saidSecret == ch.saidSecret;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), this.saidSecret);
    }
}
