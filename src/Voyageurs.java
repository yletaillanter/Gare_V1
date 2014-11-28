/**
 * Created by 14007427 on 18/11/14.
 */
public class Voyageurs extends Thread {

    private final int NB_MAX_VOYAGEURS = 500;
    private boolean ticketValide;
    private EspaceQuai espaceQuai;
    private String nom;

    public Voyageurs (String nom, EspaceQuai espaceQuai) {
        this.nom = nom;
        ticketValide = false;
        this.espaceQuai = espaceQuai;

    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        this.espaceQuai.getEspaceVente().acheterTicket();
        ticketValide = true;
        System.out.println(""+getNom()+" j'ai acheté un billet");
        espaceQuai.accederAuTrain();
        System.out.println(""+getNom()+" je suis monté dans le train.");
        ticketValide = false;
    }
}
