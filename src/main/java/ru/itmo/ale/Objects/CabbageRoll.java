package ru.itmo.ale.Objects;

import ru.itmo.ale.Enums.Ingredients;

public final class CabbageRoll extends Meal
{
    public CabbageRoll ()
    {
        super("Cabbage Roll", true);
        this.addIngredient(Ingredients.CABBAGE_LEAF);
        this.addIngredient(Ingredients.RICE);
        this.addIngredient(Ingredients.BEAF);
        this.addIngredient(Ingredients.ONION);
    }

    public Meal unrollCabbage ()
    {
        Meal cabbageLeaf = new Meal("Cabbage Leaf", true);
        for (Ingredients ingredient : this.getIngredients())
        {
            if (ingredient == Ingredients.CABBAGE_LEAF)
            {
                this.getIngredients().remove(ingredient);
                break;
            }
        }
        return cabbageLeaf;
    }
}
