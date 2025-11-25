package ru.itmo.ale.Record;

import ru.itmo.ale.Characters.Bethan;
import ru.itmo.ale.Characters.Bimbo;
import ru.itmo.ale.Characters.Bosse;
import ru.itmo.ale.Characters.Dad;
import ru.itmo.ale.Characters.Karlsson;
import ru.itmo.ale.Characters.Mom;
import ru.itmo.ale.Characters.TheKid;

public record Actors (
    TheKid theKid,
    Karlsson karlsson,
    Mom mom,
    Dad dad,
    Bosse bosse,
    Bethan bethan,
    Bimbo bimbo
) {}