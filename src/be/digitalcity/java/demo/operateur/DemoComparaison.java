package be.digitalcity.java.demo.operateur;

import java.util.Scanner;

public class DemoComparaison {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = sc1;

        int a =7, b = 5;
        boolean result;

        //Pour tout
        result = a == b ; // false
        result = a != b; // true


        //Uniquement nombres
        result =  a < b; // false
        result = a > b; // true
        result = a <= b; // false
        result = a >= b; // true


        result = sc1 == sc2; // false
        result = sc3 == sc2; // true

        //
        String str1 = "salut";
        String str2 = "salut";
        String str3 = new String("salut"); // On force le new, donc en dehors de la StringPool
        String str4 = "sa" + "lut";

        result = str1 == str2; // true
        result = str1 == str3; // false
        result = str1 == str4; // true




    }
}
