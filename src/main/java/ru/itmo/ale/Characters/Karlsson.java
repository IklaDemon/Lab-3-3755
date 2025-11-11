/*
 * there's nothing really to do for this class...
 */

package ru.itmo.ale.Characters;

import ru.itmo.ale.Locations.Location;

public final class Karlsson extends Person
{
    public Karlsson (Location l)
    {
        super ("Karlsson", l);
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
