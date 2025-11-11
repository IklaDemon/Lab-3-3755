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
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Object o = (Object) obj;
        return name.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
