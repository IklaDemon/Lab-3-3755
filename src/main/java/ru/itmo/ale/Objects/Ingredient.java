package ru.itmo.ale.Objects;

/*
 * this class can be an ENUM
 */

public class Ingredient extends Object
{
    public Ingredient (String name)
    {
        super(name);
    }

    @Override
    public String toString ()
    {
        return "Name of the ingredient: " + this.name;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}