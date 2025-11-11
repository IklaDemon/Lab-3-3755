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
        TheKid theKid = new TheKid (r);
        //Karlsson karlsson = new Karlsson (gp);
        Mom mom = new Mom (gp);
        Dad dad = new Dad (gp);
        Bosse bosse = new Bosse (gp);
        Bethan Bethan = new Bethan (gp);

        Bimbo goodBoy = new Bimbo (gp);

        /*
         * start of the story
         */

        theKid.moveTo(gp);
        theKid.thinks("I will stay quite");
        mom.thinks("I wont say anything about my kid coming from the roof");
        theKid.thinks("I absolutely had to be in that roof");
        scr.nextLine();

        // nextInt will generate integers from: [0; 10)
        if (random_generator.nextInt(10) < 5)
        {
            theKid.thinks("I won't say anything about karlsson appareance in the roof before the family gathers");
            mom.setMood(Emotion.SAD, "The Kid is hiding something");
        }
        else
        {
            theKid.thinks("I will tell her the secret");
            theKid.tellSecret();
            mom.setMood(Emotion.NORMAL, "The Kid was honest");
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

        mom.speaks("Everyone!, is time to eat!");
        scr.nextLine();

        mom.seatsToTable(dr);
        dad.seatsToTable(dr);
        bosse.seatsToTable(dr);
        Bethan.seatsToTable(dr);
        theKid.seatsToTable(dr);
        goodBoy.moveTo(dr);
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
            if (theKid.eats(dr.getTable().getMeal()))
            {
                if (theKid.tellSecret())
                {
                    mom.setMood(Emotion.ANGRY, "The kid was honest too late");
                    dad.setMood(Emotion.ANGRY, "The kid did something irresponsible for his safety");
                    bosse.setMood(Emotion.NORMAL, "Bosse does not care");
                    Bethan.setMood(Emotion.NORMAL, "Bosse does not care");
                    theKid.setMood(Emotion.SAD, "everyone is asngry at him");
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
            if (goodBoy.eats(m))
            {
                goodBoy.setMood(Emotion.HAPPY, "He ate " + m.getName());
            }
        }
        catch (NoFoodException e)
        {
            System.out.println(e.getMessage());
            goodBoy.setMood(Emotion.SAD, "He didn't eat ");
        }


        logger.close();
    }    
}
