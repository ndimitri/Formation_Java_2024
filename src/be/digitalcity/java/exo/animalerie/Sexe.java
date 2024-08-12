package be.digitalcity.java.exo.animalerie;

public enum Sexe {
    MALE("M"),
    FEMELLE("F");

    private String abbreviation;

    Sexe(String abbreviation){
        this.abbreviation = abbreviation;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

}
