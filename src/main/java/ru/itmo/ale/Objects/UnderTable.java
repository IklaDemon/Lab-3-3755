package ru.itmo.ale.Objects;

import java.util.ArrayList;
import java.util.Objects;

import ru.itmo.ale.Exceptions.NoFoodException;

public class UnderTable extends Object
{
    protected ArrayList<Meal> meals;

    public UnderTable ()
    {
        super ("Under Table");
        this.meals = new ArrayList<Meal>();
    }

    public ArrayList<Meal> getMeals ()
    {
        return meals;
    }

    public void addMeal (Meal m)
    {
        meals.add(m);
    }

    public Meal getMeal () throws NoFoodException
    {
        if (meals.isEmpty()) throw new NoFoodException("No food in the table");
        return meals.get(0);
    }

    public void removeMeal (Meal m)
    {
        meals.remove(m);
    }

    /*
     * method to empty the meals list
     */
    public void removeAll ()
    {
        this.meals.clear();
    }

    /*
     * method to check if some food is present under the
     * table
     */
    public boolean isMealPresent ()
    {
        return (meals.size() > 0) ? true : false;
    }

    /*
     * to string
     */
    @Override
    public String toString ()
    {
        String res =  super.toString() + "\n";
        res += "Meals: ";
        for (int i = 0; i < meals.size(); i++)
        {
            res += meals.get(i).getName();
            if (i < meals.size() - 1) res +=  ", ";
        }
        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.meals, this.name);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        return super.equals(obj) && this.meals.equals(((Table)obj).meals);
    }
}
