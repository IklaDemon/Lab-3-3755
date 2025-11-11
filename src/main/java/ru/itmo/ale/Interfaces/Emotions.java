package ru.itmo.ale.Interfaces;

import ru.itmo.ale.Enums.Emotion;

public interface Emotions
{
    /*
     * set the mood of a character.
     * the String "reason" is present only to print
     * something, a reason...
     */
    public void setMood (Emotion emotion, String reason);

    /*
     * get mood of the character
     */
    public Emotion getMood ();

    /*
     * if the character is sad, then it should also appear
     * the crease
     */
    public void setCrease ();
}
