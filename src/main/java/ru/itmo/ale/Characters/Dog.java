package ru.itmo.ale.Characters;

import ru.itmo.ale.Locations.Location;

public abstract class Dog extends Character
{
    /*
     * constructor
     */
    public Dog (String s, Location l)
    {
        super(s, l);
    }

    @Override
    public void moveTo(Location l)
    {
        if (l != currentLocation)
        {
            System.out.println(this.name + " runs to " + l.getName());
            if (currentLocation != null)
            {
                currentLocation.removeCharacter(this);
            }
            this.currentLocation = l;
            l.addCharacter(this);
        }
    }

    /*
     * method to bark
     */
    public void barks ()
    {
        System.out.println(this.getName() + " barks!");
    }

    /*
     * to string
     */
    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
