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
        if (this.currentLocation instanceof DiningRoom)
            if (((DiningRoom)this.currentLocation).getUnderTable().isMealPresent())
            {
                System.out.println(this.getName() + " eats " + meal.getName());
                ((DiningRoom)this.currentLocation).getUnderTable().removeMeal(meal);;
                /*
                for (Meal m : ((DiningRoom)currentLocation).getUnderTable().getMeals())
                {
                    System.out.println(this.getName() + " eats " + m.getName());
                }
                ((DiningRoom)this.currentLocation).getUnderTable().removeAll();*/
                return true;
            }
        else
        {
            System.out.println(this.getName() + " is not in the dining room");
        }
        return false;
    }

    /*
     * to string
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
