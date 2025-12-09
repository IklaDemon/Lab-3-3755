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

    /*
     * method overrided to change the movement type to "runs to"
     */
    @Override
    public void moveTo(Location l)
    {
        if (l != this.getCurrentLocation())
        {
            System.out.println(this.getName() + " runs to " + l.getName());
            if (this.getCurrentLocation() != null)
            {
                this.getCurrentLocation().removeCharacter(this);
            }
            this.setCurrentLocation(l);
            l.addCharacter(this);
        }
    }

    public void speaks (String s)
    {
        System.out.println(this.getName() + " barks!");
    }
}
