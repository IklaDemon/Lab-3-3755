package ru.itmo.ale.Other;

import java.io.PrintStream;
import java.io.FileWriter;
import java.io.IOException;

    public class Logger extends PrintStream
{
    private PrintStream console;
    private FileWriter fileWriter;

    public Logger (PrintStream console)
    {
        super(console);
        this.console = console;
        try
        {
            fileWriter = new FileWriter("log.txt", true);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Overriding of the println method.
     * The method prints in both console and the "log.txt" file
     */
    @Override
    public void println (String s)
    {
        console.println(s);
        try
        {
            fileWriter.write(s + "\n");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Overriding of the print method (even tho i tho I dont use it).
     * The method prints in both console and the "log.txt" file
     */
    @Override
    public void print (String s)
    {
        console.println(s);
        try
        {
            fileWriter.write(s + "\n");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /*
     * method to close the stream and the file, let's be clean
     */
    @Override
    public void close ()
    {
        super.close ();
        try
        {
            this.fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
