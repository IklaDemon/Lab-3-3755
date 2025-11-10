package ru.itmo.ale.Interfaces;

import ru.itmo.ale.Enums.Emotion;

public interface Emotions
{
    public void setMood (Emotion emotion, String reason);
    public Emotion getMood ();

    /*
     * if the character is sad, the it should also appear the crease
     */
    public void setCrease ();
}
