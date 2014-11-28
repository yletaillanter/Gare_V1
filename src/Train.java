/**
 * Created by 14007427 on 18/11/14.
 */
public class Train extends Thread {

    private final int NB_MAX_TRAIN = 5;
    private int vitesseTrain;
    private int tempsArretTrain;
    private int capaciteTrain;
    private String nomTrain;
    private EspaceQuai quai;


    public Train(String nom, EspaceQuai quai) {
        vitesseTrain    = 100;
        tempsArretTrain = 5;
        capaciteTrain = 25;
        this.nomTrain = nom;
        this.quai = quai;
    }

    public double getVitesseTrain() {
        return vitesseTrain;
    }

    public double getTempsArretTrain() {
        return tempsArretTrain;
    }

    synchronized public int getCapaciteTrain() {
        return capaciteTrain;
    }

    public void setNomTrain(String nomTrain) {
        this.nomTrain = nomTrain;
    }

    synchronized public void monterDansTrain() {
        capaciteTrain--;
    }

    public String getNomTrain() {
        return nomTrain;
    }

    @Override
    public void run() {
        quai.entrerVoie(this);
        System.out.println(""+getNomTrain()+" : arrive en gare.");
        try {
            Thread.sleep(tempsArretTrain*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quai.quitterVoie(this);
        System.out.println(""+getNomTrain()+" a quitté la gare.");

    }
}
