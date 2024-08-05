package be.digitalcity.java.exo.oo.lanceDes;

public class DemoStatic {
    public static void main(String[] args) {

        System.out.println("Lancé d'un dés 6 faces");
        int result = LanceDes.lancerDe(6);
        System.out.println(result);


        System.out.println("Lancé dés 6 faces 5 fois");
        System.out.println(LanceDes.lancerDe(6, 5));

        System.out.println(LanceDes.lancerDe(6, 10, 3));




    }

}
