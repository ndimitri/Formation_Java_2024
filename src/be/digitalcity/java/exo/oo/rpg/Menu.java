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
        sb.append("z: haut").append("\n");
        sb.append("s: bas").append("\n");
        sb.append("q: gauche").append("\n");
        sb.append("d: droite").append("\n");
        sb.append("i: inventaire").append("\n");
        sb.append("b: boutique").append("\n");
        sb.append("p: heros").append("\n");
        sb.append("r: quitter").append("\n");
        System.out.println(sb);
    }

    public void afficherMenuHeros(Heros heros){
        StringBuilder sb = new StringBuilder();
        sb.append("Attributs :").append("\n");
        sb.append("STAMINA: ").append(heros.getEndurance()).append("\n");
        sb.append("FORCE: ").append(heros.getForce()).append("\n");
        sb.append("PV: ").append(heros.getPV()).append("\n");
    }

}
