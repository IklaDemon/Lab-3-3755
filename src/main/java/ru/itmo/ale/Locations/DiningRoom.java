package ru.itmo.ale.Locations;

import ru.itmo.ale.Objects.Table;

//import ru.itmo.ale.Classes.Location;

public class DiningRoom extends Location
{
    protected Table table;

    public DiningRoom ()
    {
        super ("Dining Room");
        table = new Table();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
