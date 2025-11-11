package ru.itmo.ale.Characters;

import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;

public abstract class Person extends Character
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
        System.out.println(this.name + " sat in the table");
    }

    @Override
    public void moveTo(Location l)
    {
        if (l != currentLocation)
        {
            System.out.println(this.name + " walks to " + l.getName());
            if (currentLocation != null)
            {
                currentLocation.removeCharacter(this);
            }
            this.currentLocation = l;
            l.addCharacter(this);
        }
    }

    /*
     * method to speak
     */
    public void speaks (String s)
    {
        System.out.println(this.name + " says: " + s);
    }

    /*
     * method to think
     */
    public void thinks (String s)
    {
        System.out.println(this.name + " thinks: " + s);
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
