package ru.itmo.ale.Objects;

import java.util.ArrayList;
import java.util.Objects;

import ru.itmo.ale.Exceptions.NoFoodException;

public class Table extends Object
{
    protected ArrayList<Meal> mealsOnTheTable;
    protected ArrayList<Meal> mealsUnderTheTable;

    public Table ()
    {
        super("Table");
        this.mealsOnTheTable = new ArrayList<Meal>();
        this.mealsUnderTheTable = new ArrayList<Meal>();
    }

    public void addMealOnTheTable (Meal m)
    {
        mealsOnTheTable.add(m);
    }

    public void addMealUnderTheTable (Meal m)
    {
        mealsUnderTheTable.add(m);
    }

    public Meal getMealOnTheTable () throws NoFoodException
    {
        if (mealsOnTheTable.isEmpty()) throw new NoFoodException("No food on the table");
        return mealsOnTheTable.get(0);
    }

    public Meal getMealUndertTheTable () throws NoFoodException
    {
        if (mealsUnderTheTable.isEmpty()) throw new NoFoodException("No food under the table");
        return mealsUnderTheTable.get(0);
    }

    public void removeMealOnTheTable (Meal m)
    {
        mealsOnTheTable.remove(m);
    }

    public void removeMealUnderTheTable (Meal m)
    {
        mealsUnderTheTable.remove(m);
    }

    /*
     * this methid is used by the kid to throw the food
     * undert table if he doesn't like it
     */
    public void throwMealUnderTheTable (Meal m)
    {
        mealsOnTheTable.remove(m);
        mealsUnderTheTable.add(m);
    }

    /*
     * Checks if there's somethind undert the table, this method is used by the dog
     */
    public boolean isMealUnderTheTablePresent ()
    {
        if (mealsUnderTheTable.isEmpty()) return false;
        return true;
    }

    /*
     * to string
     */
    @Override
    public String toString ()
    {
        String res =  super.toString() + "\n";
        res += "Meals on the table: ";
        for (int i = 0; i < mealsOnTheTable.size(); i++)
        {
            res += mealsOnTheTable.get(i).getName();
            if (i < mealsOnTheTable.size() - 1) res +=  ", ";
        }
        res += "\nMeals under the table: ";
        for (int i = 0; i < mealsUnderTheTable.size(); i++)
        {
            res += mealsUnderTheTable.get(i).getName();
            if (i < mealsUnderTheTable.size() - 1) res +=  ", ";
        }
        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.mealsOnTheTable, this.mealsUnderTheTable, this.name);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        return super.equals(obj) && this.mealsOnTheTable.equals(((Table)obj).mealsOnTheTable) && this.mealsUnderTheTable.equals(((Table)obj).mealsUnderTheTable);
    }
}