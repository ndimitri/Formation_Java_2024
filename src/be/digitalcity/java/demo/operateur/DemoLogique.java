package be.digitalcity.java.demo.operateur;

public class DemoLogique {
    public static void main(String[] args) {

        boolean a = true, b = false, result;

        //AND - &&
        System.out.println(true && true);  // true
        System.out.println(true && false); // false
        System.out.println(false && true); // false
        System.out.println(true && false); // false


        // OR - ||
        System.out.println(false || false); // false
        System.out.println(false || true); // true
        System.out.println(true || false); // true
        System.out.println(true || true); // true


        // NOT - !
        System.out.println( !true); // false
        System.out.println( !false); //true

        //XOR - ^
        System.out.println( true ^ false); // true
        System.out.println( false ^ true); // true
        System.out.println( true ^ true); // false
        System.out.println( false ^ false); // false


        // Loi de De Morgan
        boolean estBleu = true, estLignee = true;

        System.out.println(!(estBleu && estLignee));
        System.out.println(!estBleu || !estLignee);

        System.out.println(!(estBleu || estLignee));
        System.out.println(!estBleu && !estLignee);


        int temp = 18;
        boolean allumer = temp >= 5 && temp <= 15;
        boolean fermer = temp < 5 || temp > 15;

        // Operateur ternaire
        int age = 15;

        String majorite = age >=18 ? "majeur" : "mineur";







    }
}
