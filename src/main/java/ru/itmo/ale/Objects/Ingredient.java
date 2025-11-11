package ru.itmo.ale.Objects;

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
