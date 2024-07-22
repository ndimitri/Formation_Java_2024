package be.digitalcity.java.demo.operateur;

public class DemoOperateur {
    public static void main(String[] args) {

        //Operateur arithmetiques
        int a = 7, b = 5;
        double result;

        result = a + b; // 13
        result = a - b; // 7
        result = a * b; // 30
        result = a / b; // 3
        result = (double) a / b; // 3.333...
        result = a % b; // 1

        result = result + 2;
        result += 2;

        result = result * 2;
        result *= 2;

        //Incrementation+Decrementation

        int variable = 0;


        System.out.println(variable++); // 0 recup => incr
        System.out.println(++variable); // 2 incr => recup

        System.out.println(variable--); // 2 recup => decr
        System.out.println(--variable); // 0 decr => recup

        System.out.println(variable); // 0

        //Affectation

        System.out.println(variable = 5); // 5

        System.out.println(variable += 5); // 10

        System.out.println(variable = variable++); // 10


        //intervertir des variables sans variables temp
        int c = 78, d = 102;

        //1
        c = c * d ;
        d = c / d;
        c = c / d;

        //2
        c = c + d;
        d = c - d;
        c = c - d;



    }
}
