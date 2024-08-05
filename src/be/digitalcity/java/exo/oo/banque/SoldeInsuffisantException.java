package be.digitalcity.java.exo.oo.banque;

public class SoldeInsuffisantException extends RuntimeException{

    public SoldeInsuffisantException() {
        super("Solde insuffisant");
    }

    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
