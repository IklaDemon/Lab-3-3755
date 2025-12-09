package ru.itmo.ale.Other;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import ru.itmo.ale.Characters.Bimbo;
import ru.itmo.ale.Characters.TheKid;
import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Enums.Ingredients;
import ru.itmo.ale.Exceptions.NoFoodException;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;
import ru.itmo.ale.Record.Actors;
import ru.itmo.ale.Characters.Mom;
import ru.itmo.ale.Characters.Person;

public class Runner
{
    /*
     * this method creates all the entities and objects for the story to take place 
     */
    public void run ()
    {
        // random
        Random random_generator = new Random();

        // input
        Scanner scr = new Scanner(System.in);

        // logger
        PrintStream console = System.out;
        Logger logger = new Logger(console);
        try
        {
            System.setOut(logger);
        }
        catch (SecurityException e)
        {
            System.out.println("Something exploded in the standard stream redirection: " + e.getMessage());
            System.out.println("Output will be printed only in console");
        }

        // locations
        DiningRoom dr = new DiningRoom ();
        Location gp = new Location("GeneralPlace");
        Location r = new Location ("Roof");

        // characters
        Person bethan = new Person("Bethan", gp);
        Person bosse = new Person("Bosse", gp);
        Person dad = new Person("Dad", gp);
        Person karlsson = new Person("Karlsson", gp);
        Actors actors = new Actors(new TheKid(r), karlsson, new Mom(gp), dad, bosse, bethan, new Bimbo(gp));

        /*
         * start of the story
         */

        actors.theKid().moveTo(gp);
        actors.theKid().thinks("I will remain silent");
        actors.mom().thinks("I wont say anything about my kid coming from the roof");
        actors.theKid().thinks("I absolutely had to be in that roof");
        scr.nextLine();

        // nextInt will generate integers from: [0; 10)
        // 50% chance of the Kid telling the secret
        if (random_generator.nextInt(10) < 5)
        {
            actors.theKid().thinks("I won't say anything about karlsson appareance in the roof before the family gathers");
            actors.mom().setMood(Emotion.SAD, "The Kid is hiding something");
        }
        else
        {
            actors.theKid().thinks("I will tell her the secret");
            actors.theKid().tellSecret();
            actors.mom().setMood(Emotion.NORMAL, "The Kid was honest");
        }
        scr.nextLine();

        System.out.println("Family is assembled");
        scr.nextLine();

        // nextInt will generate integers from: [0; 10)
        // 50% chance of the food being Hamburger or Cabbage Roll
        if (random_generator.nextInt(10) < 5)
        {
            Meal m = new Meal("Hamburger", false);
            m.addIngredient(Ingredients.BREAD);
            m.addIngredient(Ingredients.MEAT);
            m.addIngredient(Ingredients.KETCHUP);
            m.addIngredient(Ingredients.SALAD);
            m.addIngredient(Ingredients.CHEESE);
            m.addIngredient(Ingredients.BACON);

            dr.getTable().addMealOnTheTable(m);
            dr.getTable().addMealOnTheTable(m.copy());
            dr.getTable().addMealOnTheTable(m.copy());
            dr.getTable().addMealOnTheTable(m.copy());
            dr.getTable().addMealOnTheTable(m.copy());
        }
        else
        {
            dr.getTable().addMealOnTheTable(new CabbageRoll());
            dr.getTable().addMealOnTheTable(new CabbageRoll());
            dr.getTable().addMealOnTheTable(new CabbageRoll());
            dr.getTable().addMealOnTheTable(new CabbageRoll());
            dr.getTable().addMealOnTheTable(new CabbageRoll());
        }

        actors.mom().speaks("Everyone!, is time to eat!");
        scr.nextLine();

        actors.mom().seatsToTable(dr);
        actors.dad().seatsToTable(dr);
        actors.bosse().seatsToTable(dr);
        actors.bethan().seatsToTable(dr);
        actors.theKid().seatsToTable(dr);
        actors.bimbo().moveTo(dr);
        scr.nextLine();

        try
        {
            System.out.println("For dinner there was: " + dr.getTable().getMealOnTheTable().getName());
        }
        catch (NoFoodException e)
        {
            System.out.println(e.getMessage());
        }
        scr.nextLine();

        try
        {
            if (actors.theKid().eats(dr.getTable().getMealOnTheTable()))
            {
                if (actors.theKid().tellSecret())
                {
                    actors.mom().setMood(Emotion.ANGRY, "The kid was honest too late");
                    actors.dad().setMood(Emotion.ANGRY, "The kid did something irresponsible for his safety");
                    actors.bosse().setMood(Emotion.NORMAL, "Bosse does not care");
                    actors.bethan().setMood(Emotion.NORMAL, "Bethan does not care");
                    actors.theKid().setMood(Emotion.SAD, "everyone is angry at him");
                }
            }
        }
        catch (NoFoodException e)
        {
            System.out.println(e.getMessage());
        }
        scr.nextLine();

        try
        {
            Meal m = dr.getTable().getMealUnderTheTable();
            if (actors.bimbo().eats(m))
            {
                actors.bimbo().setMood(Emotion.HAPPY, "He ate " + m.getName());
            }
        }
        catch (NoFoodException e)
        {
            System.out.println(e.getMessage());
            actors.bimbo().setMood(Emotion.SAD, "He didn't eat ");
        }

        logger.close();
        scr.close();
    }    
}