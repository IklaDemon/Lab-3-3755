package ru.itmo.ale.Objects;

import java.util.ArrayList;
import java.util.Objects;

import ru.itmo.ale.Enums.Ingredients;

public class Meal extends Object
{
    private boolean isHealthy;
    private ArrayList<Ingredients> ingredients;

    /*
     * constructor
     */
    public Meal (String n, boolean isHealthy)
    {
        super (n);
        this.isHealthy = isHealthy;
        ingredients = new ArrayList<Ingredients>();
    }

    public boolean isHealthy ()
    {
        return isHealthy;
    }

    /*
     * add ingredient
     */
    public void addIngredient (Ingredients i)
    {
        this.ingredients.add(i);
    }

    /*
     * get all the ingredients in ArrayList
     */
    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public Meal copy ()
    {
        Meal m = new Meal(this.name, this.isHealthy);
        for (Ingredients ingredient : ingredients)
            m.addIngredient(ingredient);
        return m;   
    }

    /*
     * to string
     */
    @Override
    public String toString()
    {
        String str = "Name of the meal: " + this.name;
        str += "\nIshealthy: " + this.isHealthy;
        str += "\nIngredients: ";
        for (int i = 0; i < ingredients.size(); i++)
        {
            str += ingredients.get(i).name();
            if (i < ingredients.size() - 1) str +=  ", ";
        }
        return str;
    }

    @Override
    public boolean equals(java.lang.Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Meal)) return false;
        if (!super.equals(obj)) return false;
        Meal m = (Meal) obj;
        return this.isHealthy == m.isHealthy() && Objects.equals(this.ingredients, m.getIngredients());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), this.isHealthy, this.ingredients);
    }
}
