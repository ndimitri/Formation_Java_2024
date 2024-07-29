package be.digitalcity.java.exo.oo.competition;


import java.util.HashSet;
import java.util.Set;

public class Competition {
    static final int NOMBRE_PARTICIPANTS_MIN_DEFAULT = 3;
    static final int NOMBRE_PARTICIPANTS_MAX_DEFAULT = 12;

    //Variables
    final int nbrMinParticipant, nbrMaxParticipant;
    //Lancé / Pas lancé
    boolean status;
    final Set<Personne> participants;


    Competition(int nbrMinParticipant, int nbrMaxParticipant){
        this.nbrMinParticipant = nbrMinParticipant;
        this.nbrMaxParticipant = nbrMaxParticipant;
        this.status = false;
        this.participants = new HashSet<>();
    }

    Competition(){
        this(NOMBRE_PARTICIPANTS_MIN_DEFAULT, NOMBRE_PARTICIPANTS_MAX_DEFAULT);
    }

    Competition(int nbrMaxParticipant) {
        this(NOMBRE_PARTICIPANTS_MIN_DEFAULT, nbrMaxParticipant);
    }

//    Competition(int nbrMinParticipant) {
//        this(nbrMinParticipant, NOMBRE_PARTICIPANTS_MAX_DEFAULT);
//    }




    boolean lancer(){
        //Si la compétition n'est pas encore lancée et qu'il y a le nbr min de participants -> la compet est lancée
        if( !status && participants.size() >= nbrMinParticipant ){
            status = true;
            return true;
        }
        //Sinon return false
        else{
            return false;
        }
    }

    boolean ajouterParticipant(Personne personne){
        //Si la compet n'est pas encore lancé et qu'il y a encore de la place --> on ajoute le participant
        if(!status && participants.size() < nbrMaxParticipant  ){
            participants.add(personne);
            return true;
        }
        else {
            return false;
        }
    }



}
