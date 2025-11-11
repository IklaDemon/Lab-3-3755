package ru.itmo.ale.Objects;

import java.util.ArrayList;

import ru.itmo.ale.Characters.Character;

public class Table extends Object
{
    protected ArrayList<Meal> meals;
    protected ArrayList<Character> PeopleSeating;

    public Table ()
    {
        super("Table");
        meals = new ArrayList<Meal>();
        PeopleSeating = new ArrayList<Character>();
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void addMeal (Meal m)
    {
        meals.add(m);
    }

    public void removeMeal (Meal m)
    {
        meals.remove(m);
    }
}