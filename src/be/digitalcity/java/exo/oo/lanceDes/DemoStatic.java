package be.digitalcity.java.exo.oo.lanceDes;

public class DemoStatic {
    public static void main(String[] args) {
//region Exo Static
//        System.out.println("Lancé d'un dés 6 faces");
//        int result = LanceDes.lancerDe(6);
//        System.out.println(result);
//
//
//        System.out.println("Lancé dés 6 faces 5 fois");
//        System.out.println(LanceDes.lancerDe(6, 5));
//
//        System.out.println(LanceDes.lancerDe(6, 10, 3));
//endregion

        System.out.println(LancerDes.lancerDe(LancerDes.SIX.nbrFaces, 3, 2));
        System.out.println(LancerDes.lancerDe(LancerDes.CENT.nbrFaces, 10, 5));


    }

}
