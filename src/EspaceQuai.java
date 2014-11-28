import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 14007427 on 18/11/14.
 */
public class EspaceQuai {

    private final int NB_VOIES = 2;
    private int voiesDispo;
    private int trainsEnQuai;
    private Collection<Train> listeTrainQuai;

    public EspaceVente espaceVente;

    EspaceQuai(EspaceVente espaceVente){
        voiesDispo = NB_VOIES;
        trainsEnQuai = 0;
        listeTrainQuai = new ArrayList<Train>();
        this.espaceVente = espaceVente;
    }

    synchronized public void entrerVoie(Train train){
        if(voiesDispo == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Pour les voyageurs en attente
        voiesDispo--;
        notifyAll();
        listeTrainQuai.add(train);
        System.out.println("Train en gare" + train.getNomTrain());
    }

    synchronized public void quitterVoie(Train train){
        listeTrainQuai.remove(train);
        voiesDispo++;
        // Pour les trains en attente d'un quai libre.
        notifyAll();
    }

    synchronized public void accederAuTrain () {
        boolean monte = false;
        while(true) {
            Iterator<Train> it = listeTrainQuai.iterator();
            while (it.hasNext()) {
                Train train = it.next();
                if (train.getCapaciteTrain() > 0){
                    train.monterDansTrain();
                    monte = true;
                    break;
                }
            }
            if(!monte) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
                break;

        }
    }

    public EspaceVente getEspaceVente() {
        return espaceVente;
    }




}
