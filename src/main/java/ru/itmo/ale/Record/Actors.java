package ru.itmo.ale.Record;

import ru.itmo.ale.Characters.Bimbo;
import ru.itmo.ale.Characters.Mom;
import ru.itmo.ale.Characters.Person;
import ru.itmo.ale.Characters.TheKid;

public record Actors (
    TheKid theKid,
    Person karlsson,
    Mom mom,
    Person dad,
    Person bosse,
    Person bethan,
    Bimbo bimbo
) {}