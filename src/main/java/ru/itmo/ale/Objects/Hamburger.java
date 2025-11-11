package ru.itmo.ale.Objects;

public class Hamburger extends Meal
{
    public Hamburger ()
    {
        super ("Hamburger", false);
        this.addIngredient(new Ingredient("Bread"));
        this.addIngredient(new Ingredient("Meat"));
        this.addIngredient(new Ingredient("Ketchup"));
        this.addIngredient(new Ingredient("Salad"));
        this.addIngredient(new Ingredient("Cheese"));
        this.addIngredient(new Ingredient("Bacon"));
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        return super.equals(obj);
    }
}