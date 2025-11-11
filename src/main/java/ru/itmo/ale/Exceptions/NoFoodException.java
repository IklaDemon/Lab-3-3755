package ru.itmo.ale.Exceptions;

public class NoFoodException extends Exception
{
    public NoFoodException(String erroreMessage)
    {
        super (erroreMessage);
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + " [Overrided method]";
    }
}
