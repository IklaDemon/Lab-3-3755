package ru.itmo.ale.Objects;

import java.util.Objects;

public class Object
{
    protected String name;

    public Object (String name)
    {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString ()
    {
        return "Name of the object: " + this.name;
    }

    @Override
    public boolean equals (java.lang.Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Object)) return false;
        Object o = (Object) obj;
        return this.name.equals(o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
