package Classes;

import java.util.ArrayList;

public class Location
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

    public Character getCharacter (Character c)
    {
        return this.characters.get(characters.indexOf(c));
    }

    public String toString() {
        String out = "";
        out += "Location name = " + this.name + "\nPeople present:";
        for (Character character : characters)
        {
            out += "\n" + character.getName();
        }
        return out;
    }
}
