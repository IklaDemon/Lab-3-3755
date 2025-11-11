package ru.itmo.ale.Characters;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Locations.Location;

public abstract class Dog extends Character
{
    public Dog (String s, Emotion e, boolean b, Location l)
    {
        super(s, e, b, l);
    }

    public void barks ()
    {
        System.out.println(this.getName() + " barks!");
    }
}
