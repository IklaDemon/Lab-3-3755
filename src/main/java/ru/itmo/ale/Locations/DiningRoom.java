package ru.itmo.ale.Locations;

import java.util.Objects;

import ru.itmo.ale.Objects.Table;

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

    @Override
    public String toString()
    {
        String res = super.toString();
        res += "\n" + this.table.toString();
        return res;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof DiningRoom)) return false;
        if (!super.equals(obj)) return false;
        DiningRoom dr = (DiningRoom) obj;
        return Objects.equals(this.table, dr.table);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), this.table);
    }
}
