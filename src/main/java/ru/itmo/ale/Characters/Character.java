package ru.itmo.ale.Characters;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Interfaces.Emotions;
import ru.itmo.ale.Locations.Location;

public abstract class Character implements Emotions
{
    protected String name;
    protected Emotion mood;
    protected boolean hasCrease;
    protected Location curreLocation;

    public Character ()
    {
        this.name = "Unknow";
        this.mood = Emotion.NORMAL;
        this.hasCrease = false;
        this.curreLocation = null;
    }

    public Character (String name, Emotion emotion, boolean hasCrease, Location currentLocation)
    {
        this.name = name;
        this.mood = emotion;
        this.hasCrease = hasCrease;
        this.curreLocation = currentLocation;
    }

    public void setName (String name) { this.name = name; }
    public String getName () { return this.name; }

    public void setMood (Emotion emotion, String reason)
    {
        this.mood = emotion;
        System.out.println (this.name + " change to " + emotion + " because of " + reason);
    }

    public Emotion getMood ()
    {
        return this.mood;
    }

    public void setCrease ()
    {
        switch (this.mood)
        {
            case ANGRY: case SAD: case SUSPICIOUS:
                this.hasCrease = true;
                break;
            default:
            this.hasCrease = false;
                break;
        }
    }

    /*
     * qui devo fare magia
     */
    public void moveTo (Location l)
    {
        ;
    }

    public String toString () { return "Name: " + this.name + ", Mood: " + this.mood; }
}
