package ru.itmo.ale.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ru.itmo.ale.Exceptions.NoFoodException;

public class TableTest
{
    @Test
    void getMealOnTheTable_noFood_exception ()
    {
        Table t = new Table();
        /*
        NoFoodException exception = assertThrows(
            NoFoodException.class,
            () -> t.getMealOnTheTable()
        );*/
        assertThrows(NoFoodException.class, () -> t.getMealOnTheTable());
    }

    @Test
    void getMealOnTheTable_FoodIsPresent_exception ()
    {
        Table t = new Table();
        Meal m = mock(Meal.class);

        t.addMealOnTheTable(m);

        try
        {
            assertSame(m, t.getMealOnTheTable(), "Should return the same meal");
        }
        catch (NoFoodException e) {}
    }

    @Test
    void getMealUnderTheTable_noFood_exception ()
    {
        Table t = new Table();
        assertThrows(NoFoodException.class, () -> t.getMealUnderTheTable());
    }

    @Test
    void getMealUnderTheTable_FoodIsPresent_exception ()
    {
        Table t = new Table();
        Meal m = mock(Meal.class);

        t.addMealUnderTheTable(m);

        try
        {
            assertSame(m, t.getMealUnderTheTable(), "Should return the same meal");
        }
        catch (NoFoodException e) {}
    }

    @Test
    void throwMealUnderTheTable_checkArraysUpdateTheMeal ()
    {
        Table t = new Table();
        Meal m = mock(Meal.class);

        t.addMealOnTheTable(m);

        t.throwMealUnderTheTable(m);

        assertFalse(t.getMealsOnTheTable().contains(m), "Meal should not be present");
        assertTrue(t.getMealsUnderTheTable().contains(m), "Meal should be present");
    }
}