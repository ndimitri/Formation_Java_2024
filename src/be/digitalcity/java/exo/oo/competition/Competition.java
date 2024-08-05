package be.digitalcity.java.exo.oo.competition;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Competition<C extends Competiteur>{
    public static final int NOMBRE_PARTICIPANTS_MIN_DEFAULT = 3;
    public  static final int NOMBRE_PARTICIPANTS_MAX_DEFAULT = 12;

    //Variables
    private final int nbrMinParticipant, nbrMaxParticipant;
    //Lancé / Pas lancé
    private boolean status;
    private final Set<C> participants;
    private Podium podium;



    Competition(int nbrMinParticipant, int nbrMaxParticipant){
        this.nbrMinParticipant = nbrMinParticipant;
        this.nbrMaxParticipant = nbrMaxParticipant;
        this.status = false;
        this.participants = new HashSet<C>();
        this.podium = new Podium();
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

    public Set<C> getParticipants() {
        return Set.copyOf(participants);
    }

    public Podium getPodium() {
        return podium;
    }

    boolean lancer(){
        //Si la compétition n'est pas encore lancée et qu'il y a le nbr min de participants -> la compet est lancée
        if( !status && participants.size() >= nbrMinParticipant ){
            status = true;
            performanceCompetiteurs();
            return true;
        }
        //Sinon return false
        return false;
    }

    private void performanceCompetiteurs(){

        //Créer une Map (Competiteur, Double) pour stocker les performances des participants
        Map<C, Double> mapPerformancesParticipants = new HashMap<>();
        for (C participant : participants) {
            mapPerformancesParticipants.put(participant, participant.performer());
        }

        // Convertir la Map en List
        List<Map.Entry<C, Double>> entries = new ArrayList<>(mapPerformancesParticipants.entrySet());

        //Trier la List en fonction de ses valeurs (en fonction des performances des competiteurs)
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        //Place de l'or
        podium.setOr(entries.getFirst().getKey());
        //Place de l'argent
        podium.setArgent(entries.get(1).getKey());
        //Place de bronze
        podium.setBronze(entries.get(2).getKey());

    }





    boolean inscrireParticipant(C competiteur){
        //Si la compet n'est pas encore lancé et qu'il y a encore de la place --> on ajoute le participant
        if(!status && participants.size() < nbrMaxParticipant  ){
            participants.add(competiteur);
            return true;
        }

        return false;

    }

    boolean desinscrireParticipant(C competiteur){
        //Si la compet n'est pas encore lancé et que le participant est deja inscrit --> on remove le participant
        if(!status && competiteur != null){
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
