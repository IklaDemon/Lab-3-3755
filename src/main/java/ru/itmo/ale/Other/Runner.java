package ru.itmo.ale.Other;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import ru.itmo.ale.Characters.Bethan;
import ru.itmo.ale.Characters.Bimbo;
//import ru.itmo.ale.Characters.Karlsson;
import ru.itmo.ale.Characters.TheKid;
import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Exceptions.NoFoodException;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.GeneralPlace;
import ru.itmo.ale.Locations.Roof;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Hamburger;
import ru.itmo.ale.Objects.Meal;
import ru.itmo.ale.Characters.Dad;
import ru.itmo.ale.Characters.Karlsson;
import ru.itmo.ale.Characters.Bosse;
import ru.itmo.ale.Characters.Mom;

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
        GeneralPlace gp = new GeneralPlace();
        Roof r = new Roof ();

        // characters
        Actors actors = new Actors(new TheKid(r), new Karlsson(r), new Mom(r), new Dad(r), new Bosse(r), new Bethan(r), new Bimbo(r));
        /*TheKid theKid = new TheKid (r);
        //Karlsson karlsson = new Karlsson (gp);
        Mom mom = new Mom (gp);
        Dad dad = new Dad (gp);
        Bosse bosse = new Bosse (gp);
        Bethan bethan = new Bethan (gp);
        Bimbo goodBoy = new Bimbo (gp);*/

        /*
         * start of the story
         */

        actors.theKid().moveTo(gp);
        actors.theKid().thinks("I will stay quite");
        actors.mom().thinks("I wont say anything about my kid coming from the roof");
        actors.theKid().thinks("I absolutely had to be in that roof");
        scr.nextLine();

        // nextInt will generate integers from: [0; 10)
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
        if (random_generator.nextInt(10) < 5)
        {
            dr.getTable().addMeal(new Hamburger());
            dr.getTable().addMeal(new Hamburger());
            dr.getTable().addMeal(new Hamburger());
            dr.getTable().addMeal(new Hamburger());
            dr.getTable().addMeal(new Hamburger());
        }
        else
        {
            dr.getTable().addMeal(new CabbageRoll());
            dr.getTable().addMeal(new CabbageRoll());
            dr.getTable().addMeal(new CabbageRoll());
            dr.getTable().addMeal(new CabbageRoll());
            dr.getTable().addMeal(new CabbageRoll());
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
            System.out.println("For dinner there was: " + dr.getTable().getMeal().getName());
        }
        catch (NoFoodException e)
        {
            System.out.println(e.getMessage());
        }
        scr.nextLine();

        try
        {
            if (actors.theKid().eats(dr.getTable().getMeal()))
            {
                if (actors.theKid().tellSecret())
                {
                    actors.mom().setMood(Emotion.ANGRY, "The kid was honest too late");
                    actors.dad().setMood(Emotion.ANGRY, "The kid did something irresponsible for his safety");
                    actors.bosse().setMood(Emotion.NORMAL, "Bosse does not care");
                    actors.bethan().setMood(Emotion.NORMAL, "Bosse does not care");
                    actors.theKid().setMood(Emotion.SAD, "everyone is asngry at him");
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
            Meal m = dr.getUnderTable().getMeal();
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
