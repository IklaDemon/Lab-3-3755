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
}
