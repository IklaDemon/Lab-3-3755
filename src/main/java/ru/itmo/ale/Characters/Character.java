package ru.itmo.ale.Characters;

import java.util.Objects;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Interfaces.Emotions;
import ru.itmo.ale.Interfaces.Eater;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.Meal;

public abstract class Character implements Emotions, Eater
{
    private String name;
    private Emotion mood;
    private boolean hasCrease;
    private Location currentLocation;

    /*
     * constructor
     */
    public Character (String name, Location l)
    {
        this.name = name;
        this.mood = Emotion.NORMAL;
        this.hasCrease = false;
        this.currentLocation = Objects.requireNonNull(l, "Location can't be null");
        l.addCharacter(this);
    }

    // name setter and getter
    public void setName (String name) { this.name = name; }
    public String getName () { return this.name; }
    // Location setter and getter
    public void setCurrentLocation(Location currentLocation) { this.currentLocation = currentLocation; }
    public Location getCurrentLocation() { return currentLocation; }

    /*
     * the track of the position of every character is kept in
     * both the Location class and the Character class
     */
    public abstract void moveTo (Location l);

    /*
     * absytact speaks method, should be implemented by dog and person
     */
    public abstract void speaks (String s);

    /*
     * method implemented from the Eater interface
     */
    public boolean eats (Meal meal)
    {
        if (this.currentLocation instanceof DiningRoom)
        {
            System.out.println(this.name + " eats " + meal.getName());
            ((DiningRoom)this.currentLocation).getTable().removeMealOnTheTable(meal);
            return true;
        }
        else
        {
            System.out.println(this.name + " can't eat because he is not in the Dining room ");
            return false;
        }
    }

    /*
     * methods implemented from Emotion Interface
     */
    public void setMood (Emotion emotion, String reason)
    {
        this.mood = emotion;
        System.out.println (this.name + " changes to " + emotion + " because " + reason);
    }

    public Emotion getMood () { return this.mood; }

    public void setCrease ()
    {
        if (this.hasCrease == true) System.out.println(this.getName() + " still has the crease");
        else
        {
            switch (this.mood)
            {
                case ANGRY: case SAD: case SUSPICIOUS:
                    this.hasCrease = true;
                    System.out.println("A crease has appeared in " + this.name);
                    break;
                default:
                    System.out.println("The crease disapeared in " + this.name);
                    this.hasCrease = false;
                    break;
            }
        }
    }

    public String toString ()
    {
        return "Name: " + this.name + ", Mood: " + this.mood + ", has crease: " + this.hasCrease + ", location: " + currentLocation.getName();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Character)) return false;
        Character ch = (Character) obj;
        return Objects.equals(this.name, ch.name) && this.mood == ch.mood && this.hasCrease == ch.hasCrease && Objects.equals(this.currentLocation, ch.currentLocation);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, mood, hasCrease, currentLocation);
    }
}