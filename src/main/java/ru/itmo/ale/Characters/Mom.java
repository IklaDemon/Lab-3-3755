package ru.itmo.ale.Characters;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Locations.Location;

public final class Mom extends Person
{
    public Mom (Location l)
    {
        super ("Mom", l);
    }

    /*
     * the call to dinner
     */
    public void callToDinner ()
    {
        System.out.println(this.getName() + " calls everyone to dinner");
    }

    @Override
    public void setMood(Emotion emotion, String reason)
    {
        super.setMood(emotion, reason);
        this.setCrease();
    }

    @Override
    public String toString ()
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
