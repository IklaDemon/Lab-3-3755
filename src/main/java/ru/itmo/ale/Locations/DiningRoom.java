package ru.itmo.ale.Locations;

import java.util.Objects;

import ru.itmo.ale.Objects.Table;

//import ru.itmo.ale.Classes.Location;

public final class DiningRoom extends Location
{
    protected Table table;

    /*
     * constructor
     */
    public DiningRoom ()
    {
        super ("Dining Room");
        this.table = new Table();
    }

    /*
     * getter table
     */
    public Table getTable() {
        return table;
    }

    /*
     * to string
     */
    @Override
    public String toString()
    {
        String res = super.toString();
        res += "\n" + this.table.toString();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        DiningRoom dr = (DiningRoom) obj;
        return super.equals(obj) && table.equals(dr.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.table);
    }
}
