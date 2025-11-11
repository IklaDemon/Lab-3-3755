package ru.itmo.ale.Objects;

public class CabbageRoll extends Meal
{
    public CabbageRoll ()
    {
        super("Cabbage Roll");
        this.addIngredient(new Ingredient("Cabbage Leaf", false));
        this.addIngredient(new Ingredient("Rice", false));
        this.addIngredient(new Ingredient("Beaf", false));
        this.addIngredient(new Ingredient("Onion", false));
        this.addIngredient(new Ingredient("Onion", false));
    }

    public Meal unrollCabbage ()
    {
        Meal cabbageLeaf = new Meal("Cabbage Leaf");
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
}
