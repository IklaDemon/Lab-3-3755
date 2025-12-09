/*
 * Bimbo, my favourite character, I will make him eat everything under the table
 */

package ru.itmo.ale.Characters;

import ru.itmo.ale.Objects.Meal;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;

public final class Bimbo extends Dog
{
    public Bimbo (Location l)
    {
        super ("Bimbo", l);
    }

    /*
     * override so the good boy can eat everything under the table, but only if something is present
     * and good boy is in the dining room
     */
    @Override
    public boolean eats(Meal meal)
    {
        if (this.getCurrentLocation() instanceof DiningRoom)
            if (((DiningRoom)this.getCurrentLocation()).getTable().isMealUnderTheTablePresent())
            {
                System.out.println(this.getName() + " eats " + meal.getName());
                ((DiningRoom)this.getCurrentLocation()).getTable().removeMealUnderTheTable(meal);
                return true;
            }
        else
        {
            System.out.println(this.getName() + " is not in the dining room");
        }
        return false;
    }
}
