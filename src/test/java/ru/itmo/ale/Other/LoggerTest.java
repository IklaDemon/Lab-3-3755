package ru.itmo.ale.Other;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class LoggerTest
{
    @Test
    void println_printsToConsole ()
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream mockConsole = new PrintStream(out);

        Logger l = new Logger (mockConsole);

        l.println ("Hello");

        assertTrue(out.toString().contains("Hello"));
    }
}
