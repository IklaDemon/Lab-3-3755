package ru.itmo.ale.Locations;

import java.util.ArrayList;
import java.util.Objects;

import ru.itmo.ale.Characters.Character;

public abstract class Location
{
    private String name;
    private ArrayList<Character> characters;

    public Location (String name)
    {
        this.name = name;
        characters = new ArrayList<Character>();
    }

    public void addCharacter (Character c)
    {
        this.characters.add(c);
    }

    public void removeCharacter (Character c)
    {
        this.characters.remove(c);
    }

    public ArrayList<Character> getCharacters ()
    {
        return characters;
    }

    public String getName() {
        return name;
    }

    public String toString ()
    {
        String out = "";
        out += "Location name: " + this.name + "\nPeople present:";
        for (Character character : characters)
        {
            out += "\n" + character.getName();
        }
        return out;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location l = (Location) obj;
        return this.name.equals(l.name) && this.characters.equals(l.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash (this.name, this.characters);
    }
}
