package ru.itmo.ale.Characters;

import java.util.Objects;

import ru.itmo.ale.Enums.Emotion;
import ru.itmo.ale.Interfaces.Emotions;
import ru.itmo.ale.Interfaces.Eater;
import ru.itmo.ale.Locations.DiningRoom;
import ru.itmo.ale.Locations.Location;
import ru.itmo.ale.Objects.CabbageRoll;
import ru.itmo.ale.Objects.Meal;

/**
 * Base astratta per i personaggi del gioco.
 * Incapsula stato (nome, umore, piega) e posizione.
 */
public abstract class Character implements Emotions, Eater {

    private String name;
    private Emotion mood;
    private boolean hasCrease;
    private Location currentLocation;

    public Character(String name, Location location) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.currentLocation = Objects.requireNonNull(location, "location must not be null");
        this.mood = Emotion.NORMAL;
        this.hasCrease = false;
        this.currentLocation.addCharacter(this);
    }

    // --- accessors ---
    public String getName() { return name; }
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public Emotion getMood() { return mood; }

    public Location getCurrentLocation() { return currentLocation; }

    protected void setCurrentLocation(Location location) {
        this.currentLocation = Objects.requireNonNull(location, "location must not be null");
    }

    // Sposta il personaggio (implementazione demandata alle sottoclassi).
    public abstract void moveTo(Location location);

    // --- comportamenti di Eater ---
    @Override
    public boolean eats(Meal meal) {
        Objects.requireNonNull(meal, "meal must not be null");

        if (currentLocation instanceof DiningRoom) {
            System.out.println(String.format("%s eats %s", name, meal.getName()));
            // rimuove il piatto dal tavolo; il risultato indica se è stato davvero rimosso
            boolean removed = ((DiningRoom) currentLocation).getTable().removeMeal(meal);
            if (!removed) {
                System.out.println(String.format("But %s couldn't find %s on the table", name, meal.getName()));
            }
            return removed;
        } else {
            System.out.println(String.format(
                "%s can't eat because %s is not in the Dining room",
                name, (name.endsWith("s") ? "they are" : "he is")
            ));
            return false;
        }
    }

    // N.B.: correggo il typo "Cabagge" -> "Cabbage"
    public Meal divideCabbageRoll(CabbageRoll roll) {
        Objects.requireNonNull(roll, "roll must not be null");
        System.out.println(String.format("%s unrolls %s", name, roll.getName()));
        return roll.unrollCabbage();
    }

    // Mantengo la firma ma rendo il metodo più robusto.
    public void setMood(Emotion emotion, String reason) {
        this.mood = Objects.requireNonNull(emotion, "emotion must not be null");
        String why = (reason == null || reason.isBlank()) ? "no reason given" : reason;
        System.out.println(String.format("%s changes to %s because %s", name, emotion, why));
    }

    /**
     * Aggiorna lo stato della piega in base all'umore corrente.
     * Nota: il nome originale "setCrease" era fuorviante; lascio la firma
     * per retrocompatibilità ma rendo l'effetto deterministico.
     */
    public void setCrease() {
        boolean shouldHaveCrease;
        switch (mood) {
            case ANGRY:
            case SAD:
            case SUSPICIOUS:
                shouldHaveCrease = true;
                break;
            default:
                shouldHaveCrease = false;
        }

        if (this.hasCrease != shouldHaveCrease) {
            this.hasCrease = shouldHaveCrease;
            if (hasCrease) {
                System.out.println(String.format("A crease has appeared on %s", name));
            } else {
                System.out.println(String.format("The crease disappeared on %s", name)); // fix: disappeared
            }
        } else {
            System.out.println(String.format("%s %s the crease", name, hasCrease ? "still has" : "doesn't have"));
        }
    }

    @Override
    public String toString() {
        String locationName = (currentLocation != null ? currentLocation.getName() : "<nowhere>");
        return String.format("Name: %s, Mood: %s, has crease: %s, location: %s",
                name, mood, hasCrease, locationName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Character)) return false;
        Character other = (Character) obj;
        return hasCrease == other.hasCrease
                && mood == other.mood
                && Objects.equals(name, other.name)
                && Objects.equals(currentLocation, other.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mood, hasCrease, currentLocation);
    }
}

/*
ChatGPT:

Null-safety и проверки:
Я добавил вызовы Objects.requireNonNull в ключевых местах (конструктор, сеттеры, публичные методы), чтобы предотвратить «тихие» NullPointerException. Это делает класс более надёжным — если кто-то случайно передаст null, программа сразу сообщит об ошибке с понятным сообщением.

Сообщения и опечатки:
Исправлены тексты сообщений ("disappeared", вместо "dissapeared") и грамматика английских фраз.
Также добавлено корректное обращение к персонажу в сообщениях (например, чтобы фраза звучала естественнее).
Название метода исправлено на divideCabbageRoll (в оригинале было с опечаткой — “Cabagge”).

Безопасный toString:
Метод toString() теперь не выбросит NullPointerException, если currentLocation окажется null — вместо этого выведется “<nowhere>”.

equals / hashCode:
Используются те же поля, что и в твоей версии, но теперь через Objects.equals — это защищает от NullPointerException, если одно из полей равно null.

Форматирование:
Сообщения в консоли теперь формируются через String.format — это делает их чище, единообразнее и легче читаемыми. ChatGPT:

TRANSLATION

Null-safety and checks:
I've added calls to Objects.requireNonNull in key places (constructor, setters, public methods) to prevent silent NullPointerExceptions. This makes the class more robust—if someone accidentally passes null, the program will immediately report the error with a clear message.

Messages and typos:
Message texts have been corrected ("disappeared" instead of "dissapeared") and the grammar of English phrases.
Also, the correct character address in messages has been added (for example, to make the phrase sound more natural).
The method name has been corrected to divideCabbageRoll (the original was misspelled as "Cabagge").

Safe toString:
The toString() method will no longer throw a NullPointerException if currentLocation is null—it will print "<nowhere>" instead.

equals / hashCode:
The same fields are used as in your version, but now via Objects.equals—this protects against NullPointerException if one of the fields is null.

Formatting:
Console messages are now generated using String.format—this makes them cleaner, more consistent, and easier to read.


*/