package ru.itmo.ale.Classes;

import ru.itmo.ale.Enums.Emotion;

public abstract class Character
{
    private String name;
    private Emotion mood;

    public Character ()
    {
        this.name = "Unknow";
        this.mood = Emotion.NORMAL;
    }

    public Character (String name, Emotion emotion)
    {
        this.name = name;
        this.mood = emotion;
    }

    public void setMood (Emotion emotion) { this.mood = emotion; }
    public Emotion getMood () { return this.mood; }

    public void setName (String name) { this.name = name; }
    public String getName () { return this.name; }

    public String toString () { return "Name: " + this.name + ", Mood: " + this.mood; }
}
