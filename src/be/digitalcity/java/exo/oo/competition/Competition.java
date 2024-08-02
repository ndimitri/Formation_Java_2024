package be.digitalcity.java.exo.oo.competition;


import java.util.HashSet;
import java.util.Set;

public class Competition<T extends Competiteur>{
    private static final int NOMBRE_PARTICIPANTS_MIN_DEFAULT = 3;
    private static final int NOMBRE_PARTICIPANTS_MAX_DEFAULT = 12;

    //Variables
    private final int nbrMinParticipant, nbrMaxParticipant;
    //Lancé / Pas lancé
    private boolean status;
    private final Set<T> participants;



    Competition(int nbrMinParticipant, int nbrMaxParticipant){
        this.nbrMinParticipant = nbrMinParticipant;
        this.nbrMaxParticipant = nbrMaxParticipant;
        this.status = false;
        this.participants = new HashSet<T>();
    }

    Competition(){
        this(NOMBRE_PARTICIPANTS_MIN_DEFAULT, NOMBRE_PARTICIPANTS_MAX_DEFAULT);
    }

    Competition(int nbrMaxParticipant) {
        this(NOMBRE_PARTICIPANTS_MIN_DEFAULT, nbrMaxParticipant);
    }

    //region Constructeur Competition(int nbrMinParticipant)
//    Competition(int nbrMinParticipant) {
//        this(nbrMinParticipant, NOMBRE_PARTICIPANTS_MAX_DEFAULT);
//    }

//endregion


    public int getNbrMinParticipant() {
        return nbrMinParticipant;
    }

    public int getNbrMaxParticipant() {
        return nbrMaxParticipant;
    }

    boolean lancer(){
        //Si la compétition n'est pas encore lancée et qu'il y a le nbr min de participants -> la compet est lancée
        if( !status && participants.size() >= nbrMinParticipant ){
            status = true;
            return true;
        }
        //Sinon return false
        return false;

    }



    boolean inscrireParticipant(T competiteur){
        //Si la compet n'est pas encore lancé et qu'il y a encore de la place --> on ajoute le participant
        if(!status && participants.size() < nbrMaxParticipant  ){
            participants.add(competiteur);
            return true;
        }

        return false;

    }

    boolean desinscrireParticipant(T competiteur){
        //Si la compet n'est pas encore lancé et que le participant est deja inscrit --> on remove le participant
        if(!status && participants.contains(competiteur)  ){
            participants.remove(competiteur);
            return true;
        }

        return false;

    }


    @Override
    public String toString() {
        return "Competition "+ " :\n" +
                "Participants : " + participants;
    }
}
