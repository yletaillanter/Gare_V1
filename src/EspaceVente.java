/**
 * Created by 14007427 on 18/11/14.
 */
public class EspaceVente {

    private final int TEMPS_IMPRESSION_TICKET = 1;

    public void acheterTicket() {

        try {
            Thread.sleep(TEMPS_IMPRESSION_TICKET*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
