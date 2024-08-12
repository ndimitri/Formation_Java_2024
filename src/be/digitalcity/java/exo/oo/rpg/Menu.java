package be.digitalcity.java.exo.oo.rpg;

import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;

public class Menu {

    public void selectionnerHeros(){
        StringBuilder sb = new StringBuilder();
        sb.append("Choisis ton heros").append("\n");
        sb.append("________________").append("\n");
        sb.append("1 : Humain").append("\n");
        sb.append("2 : Nain").append("\n");
        System.out.println(sb);

    }

    public void afficherMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Choisissez une action :").append("\n");
        sb.append("z: haut").append(" ");
        sb.append("s: bas").append(" ");
        sb.append("q: gauche").append(" ");
        sb.append("d: droite").append(" ");
        sb.append("i: inventaire").append(" ");
        sb.append("b: boutique").append(" ");
        sb.append("p: heros").append(" ");
        sb.append("r: quitter").append(" ");
        System.out.println(sb);
    }

    public void afficherDescriptionHeros(Heros heros){
        StringBuilder sb = new StringBuilder();
        sb.append("Attributs ").append(heros.getClass().getSimpleName()).append(" (Hero) :").append("\n");
        sb.append("STAMINA: ").append(heros.getEndurance()).append("\n");
        sb.append("FORCE: ").append(heros.getForce()).append("\n");
        sb.append("PV: ").append(heros.getPV()).append("\n");
        System.out.println(sb);
    }

    public void afficherInventaire(Heros heros){
        StringBuilder sb = new StringBuilder();
        sb.append("Inventaire :").append("\n");
        sb.append("Or : ").append(heros.getOr()).append(" | Cuir : ").append(heros.getCuir());
        System.out.println(sb);
    }

}
