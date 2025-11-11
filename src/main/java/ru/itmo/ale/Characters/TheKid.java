package ru.itmo.ale.Characters;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Locations.Roof;

public class TheKid extends Person
{
    public TheKid ()
    {
        super ("The Kid", Emotion.NORMAL, false, null);
    }

    /*
     * ah il professore è un coglione, mi ha detto che
     * table dovrebbe essere un object, ma secondo me
     * dovrebbe essere un Location
     */
    public void climbTo (Roof r)
    {
        this.moveTo (r);
    }

    @Override
    public String toString ()
    {
        return super.toString();
    }
}
