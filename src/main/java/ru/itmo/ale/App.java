package ru.itmo.ale;

import ru.itmo.ale.Characters.Bimbo;
import ru.itmo.ale.Characters.Karlsson;
import ru.itmo.ale.Characters.TheKid;
import ru.itmo.ale.Locations.Location;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // create location
        Location location = new Location("Roof");

        // print all the characters present in the location
        System.out.println(location.toString());

        // create characters
        TheKid theKid = new TheKid();
        Karlsson karlsson = new Karlsson();
        Bimbo bimbo = new Bimbo();

        // add characters to location
        location.addCharacter(theKid);
        location.addCharacter(karlsson);
        location.addCharacter(bimbo);

        // print all the characters present in the location
        System.out.println(location.toString());

        // lets get a charachter back and try to print something from it
        ((Bimbo)(location.getCharacter(bimbo))).barks();

        // delete people present in the location
        location.removeCharacter(theKid);
        location.removeCharacter(karlsson);
        location.removeCharacter(bimbo);

        // print all the characters present in the location
        System.out.println(location.toString());
    }
}
