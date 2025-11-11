package ru.itmo.ale.Characters;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Locations.Location;

public abstract class Person extends Character
{
    public Person (String s, Emotion e, boolean b, Location l)
    {
        super (s, e, b, l);
    }

    public void speaks (String s)
    {
        System.out.println(this.name + " says: " + s);
    }

    public void thinks (String s)
    {
        System.out.println(this.name + " thinks: " + s);
    }

    @Override
    public String toString ()
    {
        return super.toString();
    }
}
