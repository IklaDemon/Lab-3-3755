package ru.itmo.ale.Characters;

import java.util.Objects;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Interfaces.Emotions;
import ru.itmo.ale.Interfaces.Eater;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;

public abstract class Character implements Emotions, Eater {
    private static final String DEFAULT_CREASE_MESSAGE = " still has the crease";
    private static final String CREASE_APPEARED_MESSAGE = "A crease has appeared in ";
    private static final String CREASE_DISAPPEARED_MESSAGE = "The crease disappeared in ";
    
    private final String name;
    private Emotion mood;
    private boolean hasCrease;
    private Location currentLocation;

    public Character(String name, Location location) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.currentLocation = Objects.requireNonNull(location, "Location cannot be null");
        this.mood = Emotion.NORMAL;
        this.hasCrease = false;
        location.addCharacter(this);
    }

    public String getName() {
        return name;
    }

    public abstract void moveTo(Location location);

    @Override
    public boolean eats(Meal meal) {
        Objects.requireNonNull(meal, "Meal cannot be null");
        
        if (!(currentLocation instanceof DiningRoom)) {
            System.out.println(name + " can't eat because he is not in the Dining room");
            return false;
        }
        
        System.out.println(name + " eats " + meal.getName());
        DiningRoom diningRoom = (DiningRoom) currentLocation;
        diningRoom.getTable().removeMeal(meal);
        return true;
    }

    public Meal divideCabbageRoll(CabbageRoll cabbageRoll) {
        Objects.requireNonNull(cabbageRoll, "Cabbage roll cannot be null");
        System.out.println(name + " unrolls " + cabbageRoll.getName());
        return cabbageRoll.unrollCabbage();
    }

    @Override
    public void setMood(Emotion emotion, String reason) {
        Objects.requireNonNull(emotion, "Emotion cannot be null");
        Objects.requireNonNull(reason, "Reason cannot be null");
        
        this.mood = emotion;
        System.out.println(name + " changes to " + emotion + " because " + reason);
    }

    @Override
    public Emotion getMood() {
        return mood;
    }

    public void setCrease() {
        if (hasCrease) {
            System.out.println(name + DEFAULT_CREASE_MESSAGE);
            return;
        }
        
        switch (mood) {
            case ANGRY:
            case SAD:
            case SUSPICIOUS:
                hasCrease = true;
                System.out.println(CREASE_APPEARED_MESSAGE + name);
                break;
            default:
                hasCrease = false;
                System.out.println(CREASE_DISAPPEARED_MESSAGE + name);
                break;
        }
    }

    public boolean hasCrease() {
        return hasCrease;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public String toString() {
        return String.format("Character{name='%s', mood=%s, hasCrease=%s, location=%s}",
                name, mood, hasCrease, currentLocation.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Character character = (Character) obj;
        return hasCrease == character.hasCrease &&
                Objects.equals(name, character.name) &&
                mood == character.mood &&
                Objects.equals(currentLocation, character.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mood, hasCrease, currentLocation);
    }
}


/*
1. Immutabilità e sicurezza
Aggiunti controlli di null: Objects.requireNonNull() per parametri critici
Campi private: Incapsulamento migliore rispetto a protected
3. Miglioramenti del codice
Costanti per stringhe: Eliminazione di magic strings
Formattazione migliorata: String.format() in toString()
Logica semplificata: Rimozione di condizioni ridondanti
Getter aggiuntivi: Per hasCrease e currentLocation
4. Miglioramenti delle prestazioni
HashCode ottimizzato: Ordine coerente con equals()
Minore ripetizione di codice
5. Miglioramenti della manutenibilità
Nomi parametri più chiari: l → location, c → cabbageRoll
Struttura più coerente: Ordine logico dei metodi
Documentazione implicita: Codice più auto-esplicativo
*/