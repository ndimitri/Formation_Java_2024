package be.digitalcity.java.exo.oo.lanceDes;

import java.util.*;

public class LanceDes {
    static Random random = new Random();


    public static int lancerDe(int nbrDeFace){
        //region OLD
//        int result = random.nextInt(1, nbrDeFace+1);

        //endregion
        return lancerDe(nbrDeFace, 1, 1);
    }

    public static int lancerDe(int nbrFace, int nbrLance){
        //region OLD
        //int somme = 0;
//        for (int i = 0; i < nbrLance; i++) {
////            somme += random.nextInt(1, nbrFace +1);
//            somme += lancerDe(nbrFace);
//        }
        //endregion
        return lancerDe(nbrFace, nbrLance, nbrLance);
    }

    public static int lancerDe(int nbrFace, int nbrLance, int nbrLanceGarde) {
        List<Integer> listLanceDes = new ArrayList<Integer>();

        System.out.println("Dés lancé " + nbrLance + " fois");
        for (int i = 0; i < nbrLance; i++) {
            listLanceDes.add(random.nextInt(1, nbrFace + 1));
        }
        //  OR listLanceDes.sort(Collections.reverseOrder());
        return listLanceDes.stream().sorted(Comparator.reverseOrder()).limit(nbrLanceGarde)
            .mapToInt(it -> it).sum();
    }


}
