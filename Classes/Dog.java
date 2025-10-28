package Classes;

import Enums.Emotion;

public class Dog extends Character
{
    public Dog (String name, Emotion mood)
    {
        super (name, mood);
    }

    public void barks()
    {
        System.out.println(this.getName() + " barks!");
    }

    @Override
    public String toString ()
    {
        return super.toString();
    }
}
