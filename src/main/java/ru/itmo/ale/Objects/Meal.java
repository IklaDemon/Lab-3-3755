package ru.itmo.ale.Objects;

import java.util.ArrayList;
import java.util.Objects;

public class Meal extends Object
{
    protected boolean isHealthy;
    protected ArrayList<Ingredient> ingredients;

    /*
     * constructor
     */
    public Meal (String n, boolean isHealthy)
    {
        super (n);
        this.isHealthy = isHealthy;
        ingredients = new ArrayList<Ingredient>();
    }

    public boolean isHealthy ()
    {
        return isHealthy;
    }

    /*
     * add ingredient
     */
    public void addIngredient (Ingredient i)
    {
        this.ingredients.add(i);
    }

    /*
     * get all the ingredients in ArrayList
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /*
     * to string
     */
    @Override
    public String toString()
    {
        String str = "Name of the meal: " + this.name;
        str += "\nIshealthy: " + this.isHealthy;
        str += "Ingredients: ";
        for (int i = 0; i < ingredients.size(); i++)
        {
            str += ingredients.get(i).getName();
            if (i < ingredients.size() - 1) str +=  ", ";
        }
        return str;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Meal m = (Meal) obj;
        return this.isHealthy == m.isHealthy && this.ingredients.equals(m.ingredients) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.isHealthy, this.ingredients);
    }
}
