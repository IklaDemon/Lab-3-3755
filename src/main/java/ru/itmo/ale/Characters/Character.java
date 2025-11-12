package ru.itmo.ale.Characters;

import java.util.Objects;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Interfaces.Emotions;
import ru.itmo.ale.Interfaces.Eater;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;

public abstract class Character implements Emotions, Eater
{
    protected String name;
    protected Emotion mood;
    protected boolean hasCrease;
    protected Location currentLocation;

    /*
     * constructor
     */
    public Character (String name, Location l)
    {
        this.name = name;
        this.mood = Emotion.NORMAL;
        this.hasCrease = false;
        this.currentLocation = l;
        l.addCharacter(this);
    }

    /*
     * name setter and getter
     */
    public void setName (String name) { this.name = name; }
    public String getName () { return this.name; }

    /*
     * the track of the position of every character is kept in
     * both the Location class and the Character class
     */
    public abstract void moveTo (Location l);

    /*
     * method implemented from the Eater interface
     */
    public boolean eats (Meal meal)
    {
        if (this.currentLocation instanceof DiningRoom)
        {
            System.out.println(this.name + " eats " + meal.getName());
            ((DiningRoom)this.currentLocation).getTable().removeMeal(meal);
            return true;
        }
        else
        {
            System.out.println(this.name + " can't eat because he is not in the Dining room ");
            return false;
        }

    }

    /*
     * method implemented from the Eater interface
     */
    public Meal divideCabaggeRoll (CabbageRoll c)
    {
        System.out.println(this.name + " unrolls " + c.getName());
        return c.unrollCabbage();
    }

    /*
     * method implemented from Emotion Interface
     */
    public void setMood (Emotion emotion, String reason)
    {
        this.mood = emotion;
        System.out.println (this.name + " changes to " + emotion + " because " + reason);
    }

    /*
     * method implemented from Emotion Interface
     */
    public Emotion getMood ()
    {
        return this.mood;
    }

    /*
     * method implemented from Emotion Interface
     */
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
                    System.out.println("The crease dissapeared in " + this.name);
                    this.hasCrease = false;
                    break;
            }
        }
    }

    /*
     * to string
     */
    public String toString ()
    {
        return "Name: " + this.name + ", Mood: " + this.mood + ", has crease: " + this.hasCrease + ", location: " + currentLocation.getName();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return this.hasCrease == character.hasCrease && Objects.equals(this.name, character.name) && this.currentLocation.equals(character.currentLocation) && this.mood == character.mood;
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(this.currentLocation, this.hasCrease, this.mood, this.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(this.hasCrease, this.name, this.currentLocation, this.mood);
    }
}
