package ru.itmo.ale.Objects;

public class Ingredient extends Object
{
    protected boolean isExpired;

    public Ingredient (String name, boolean isExpired)
    {
        super(name);
        this.isExpired = isExpired;
    }
}
