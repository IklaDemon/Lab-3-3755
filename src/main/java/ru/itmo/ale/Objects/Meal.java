package ru.itmo.ale.Objects;

import java.util.ArrayList;

public class Meal extends Object
{

    protected ArrayList<Ingredient> ingredients;

    public Meal (String n)
    {
        super (n);
        ingredients = new ArrayList<Ingredient>();
    }

    public void addIngredient (Ingredient i)
    {
        this.ingredients.add(i);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
