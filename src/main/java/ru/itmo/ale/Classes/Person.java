package ru.itmo.ale.Classes;

import ru.itmo.ale.Enums.Emotion;

public abstract class Person extends Character
{
    public Person (String name, Emotion mood)
    {
        super (name, mood);
    }

    @Override
    public String toString ()
    {
        return super.toString();
    }
}
