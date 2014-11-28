/**
 * Created by 14007427 on 18/11/14.
 */


public class TestGare {

    private static final int NB_MAX_TRAIN = 4;
    private static final int NB_MAX_VOYAGEURS = 100;


    public static void main(String[] args){

        //Création gare / quai / vente
        EspaceQuai espaceQuai = new EspaceQuai(new EspaceVente());

        for (int i=0; i<=NB_MAX_VOYAGEURS; i++){
            new Voyageurs("voyageur#"+i,espaceQuai).start();
        }

        for (int i=0; i<=NB_MAX_TRAIN; i++){
            new Train("train#"+i,espaceQuai).start();
        }

    }

}
