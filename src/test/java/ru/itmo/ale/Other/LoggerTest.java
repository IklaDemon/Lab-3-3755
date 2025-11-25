package ru.itmo.ale.Other;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
        PrintStream c = new PrintStream(out);

        Logger l = new Logger (c);

        l.println ("Hello");

        assertTrue(out.toString().contains("Hello"));

        l.close();
    }

    @Test
    void close_closesFileWriter() throws Exception
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream c = new PrintStream(out);

        Logger logger = new Logger(c);
        logger.close();

        assertThrows(RuntimeException.class, () -> { logger.println("test"); } );
    }
}
