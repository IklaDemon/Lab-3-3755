package ru.itmo.ale.Characters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.Meal;

/*
 * A fake Location just to create the TheKid object
 */
class TestLocation extends Location
{
    public TestLocation ()
    {
        super("TestLocation");
    }
}

public class TheKidTest
{

    /*
     * Tests without Mockito...
     */
    @Test
    void tellSecret_firstTime_returnsAndSetsFlag ()
    {
        TheKid tk = new TheKid(new TestLocation());
        boolean res = tk.tellSecret();

        assertTrue(res, "First execution should return true");
        assertTrue(tk.saidSecret, "After first call should be true");
    }

    @Test
    void tellSecret_secondTime_returnFalse ()
    {
        TheKid tk = new TheKid(new TestLocation());
        boolean res = tk.tellSecret();

        assertTrue(res, "First execution should return true");
        res = tk.tellSecret();
        assertFalse(res, "After second call should be false");
        assertTrue(tk.saidSecret, "Should still be true");
    }

    @Test
    void moveTo_changesCurrentLocation_andUpdatesCharactersInLocation ()
    {
        DiningRoom dr1 = new DiningRoom();
        DiningRoom dr2 = new DiningRoom();
        TheKid tk = new TheKid(dr1);

        assertSame (dr1, tk.getCurrentLocation(), "Location should be the same");
        assertTrue (dr1.getCharacters().contains(tk), "The Kid should be in the location ArrayList");
        assertFalse (dr2.getCharacters().contains(tk), "Second DR should not contain the kid");

        tk.moveTo(dr2);
        assertSame (dr2, tk.getCurrentLocation(), "Location should be the same");
        assertTrue (dr2.getCharacters().contains(tk), "The Kid should be in the location's ArrayList");
        assertFalse (dr1.getCharacters().contains(tk), "First dr should not contain the kid");
    }

    @Test
    void moveTo_sameLocation_doesNothing ()
    {
        DiningRoom dr = new DiningRoom();
        TheKid tk = new TheKid(dr);

        int charactersBefore = dr.getCharacters().size();
        tk.moveTo (dr);

        assertSame (dr, tk.getCurrentLocation(), "Location should be the same");
        assertEquals(charactersBefore, dr.getCharacters().size(), "Number of characters should not change");
        assertTrue(dr.getCharacters().contains(tk), "The kid should be in the dr");
    }

    /*
     * Tests with mockito...
     * Mockito is used to fake the Location class and the
     * Meal class
     */
    @Test
    void eats_healthy_returnTrue ()
    {
        Location l = mock (Location.class);
        TheKid tk = new TheKid(l);

        Meal ml = mock (Meal.class);
        when(ml.isHealthy()).thenReturn(false);
        when(ml.getName()).thenReturn("Burger");

        boolean res = tk.eats(ml);

        assertTrue(res, "should be true when food is not healthy");
    }

    @Test
    void eats_notHealthy_returnFalse ()
    {
        Location l = mock (Location.class);
        TheKid tk = new TheKid(l);

        Meal ml = mock (Meal.class);
        when(ml.isHealthy()).thenReturn(true);
        when(ml.getName()).thenReturn("Cabbage Roll");

        boolean res = tk.eats(ml);

        assertFalse(res, "should be false when food is healthy");
    }

    /*
     * .equals () test
     */
    @Test
    void equals_sameObjs_return_true ()
    {
        Location l = mock(Location.class);
        TheKid tk1 = new TheKid(l);
        TheKid tk2 = new TheKid(l);
        Mom m = new Mom(l);

        boolean res = tk1.equals(tk2);
        assertTrue(res, "should return true when objects are different");
        res = tk1.equals(tk1);
        assertTrue(res, "Should return true when it's the same obj");
        res = tk1.equals(m);
        assertFalse(res, "Should return false: different classes");
        res = tk1.equals(null);
        assertFalse(res, "Should return false: null parameter");
    }
}
