package be.digitalcity.java.exo.oo.lanceDes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public enum LancerDes {
    SIX(6),
    DIX(10),
    VINGT(20),
    CENT(100);

    public int nbrFaces;

    static Random random = new Random();

    LancerDes(int nbrFaces){
        this.nbrFaces = nbrFaces;
    }


    public static int lancerDe(int nbrFace, int nbrLance, int nbrLanceGarde) {
        List<Integer> listLanceDes = new ArrayList<Integer>();

//        System.out.println("Un Dés magique à " + nbrFace +" faces a été lancé "+ nbrLance + " fois");
        for (int i = 0; i < nbrLance; i++) {
            listLanceDes.add(random.nextInt(1, nbrFace + 1));
        }
        //  OR listLanceDes.sort(Collections.reverseOrder());
        return listLanceDes.stream().sorted(Comparator.reverseOrder()).limit(nbrLanceGarde)
            .mapToInt(it -> it).sum();
    }

}
