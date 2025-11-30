package ru.itmo.ale.Characters;

import ru.itmo.ale.Interfaces.DivideCabbageRoll;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;

public class Person extends Character implements DivideCabbageRoll
{
    /*
     * constructor
     */
    public Person (String s, Location l)
    {
        super (s, l);
    }

    public void seatsToTable(DiningRoom dr)
    {
        this.moveTo(dr);
        System.out.println(this.getName() + " sat in the table");
    }

    @Override
    public void moveTo(Location l)
    {
        if (l != this.getCurrentLocation())
        {
            System.out.println(this.getName() + " walks to " + l.getName());
            if (this.getCurrentLocation() != null)
            {
                this.getCurrentLocation().removeCharacter(this);
            }
            this.setCurrentLocation(l);
            l.addCharacter(this);
        }
    }

    public Meal divideCabaggeRoll (CabbageRoll c)
    {
        System.out.println(this.getName() + " unrolls " + c.getName());
        return c.unrollCabbage();
    }

    /*
     * method to speak
     */
    public void speaks (String s)
    {
        System.out.println(this.getName() + " says: " + s);
    }

    /*
     * method to think
     */
    public void thinks (String s)
    {
        System.out.println(this.getName() + " thinks: " + s);
    }

    /*
     * to string
     */
    @Override
    public String toString ()
    {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
