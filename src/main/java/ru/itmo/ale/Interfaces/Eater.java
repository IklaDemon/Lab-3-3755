package ru.itmo.ale.Interfaces;

import ru.itmo.ale.Objects.Meal;

public interface Eater
{
    /*
     * action to eat, will be implemented by Character
     * it should return "true" if the eater likes the food
     * or "false" otherwise.
     */
    public boolean eats (Meal meal);
}