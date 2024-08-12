package be.digitalcity.java.exo.animalerie;

import java.lang.reflect.Type;

public enum TypePoil {
    COURT("court"),
    MILONG("mi-long"),
    LONG("long");

    private String abbreviation;

    TypePoil(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
