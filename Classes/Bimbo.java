package Classes;

import Enums.Emotion;

public class Bimbo extends Dog
{
    public Bimbo ()
    {
        super ("Bimbo", Emotion.HAPPY);
    }

    public Bimbo (Emotion e)
    {
        super ("Bimbo", e);
    }

    @Override
    public String toString ()
    {
        return super.toString();
    }
}
