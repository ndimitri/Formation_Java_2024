package be.digitalcity.java.exo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MoyenneNotesClasse {
    public static void main(String[] args) {
        //Outils
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.##");

        //Variables
        ArrayList<Double> notesEleves = new ArrayList<>();
        double total = 0;
        Double noteARajoutee;

        do{
            System.out.println("Entrez la note à ajouter (-1 pour arreter) ");
            noteARajoutee = sc.nextDouble();

            if(noteARajoutee < -1 ){
                System.out.println("Entrez une note supérieur à 0");
            }
            else if (noteARajoutee >= 0){
                notesEleves.add(noteARajoutee);
                System.out.println("La note "+ noteARajoutee + " à été ajoutée");
            }
        }while( noteARajoutee != -1);

        for(Double notes: notesEleves){
            total += notes;

        }

        System.out.println("La moyenne des notes est " +  df.format(total/notesEleves.size()));

    }
}
