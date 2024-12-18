package tp;

public class ClientFidel extends Client {
    private String codeFidelite;
    private float tauxReduction;

    public ClientFidel(String codeClient, String nomClient, String adrClient, String telClient, String codeFidelite, float tauxReduction) {
        super(codeClient, nomClient, adrClient, telClient);
        this.codeFidelite = codeFidelite;
        this.tauxReduction = tauxReduction;
    }

    
    public String toString() {
        return super.toString() +
                ", codeFidelite='" + codeFidelite + '\'' +
                ", tauxReduction=" + tauxReduction;
    }
}

