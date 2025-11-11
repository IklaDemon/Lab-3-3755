package ru.itmo.ale.Objects;

public class CabbageRoll extends Meal
{
    public CabbageRoll ()
    {
        super("Cabbage Roll", true);
        this.addIngredient(new Ingredient("Cabbage Leaf"));
        this.addIngredient(new Ingredient("Rice"));
        this.addIngredient(new Ingredient("Beaf"));
        this.addIngredient(new Ingredient("Onion"));
        this.addIngredient(new Ingredient("Onion"));
    }

    public Meal unrollCabbage ()
    {
        Meal cabbageLeaf = new Meal("Cabbage Leaf", true);
        for (Ingredient ingredient : ingredients)
        {
            if (ingredient.getName() == "Cabbage Leaf")
            {
                ingredients.remove(ingredient);
                break;
            }
        }
        return cabbageLeaf;
    }

    @Override
    public String toString() {
        return super.toString();
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
