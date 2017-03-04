/**
 * Created by Adnan on 24/11/2015.
 */
public class DiscountFF implements IDiscountStrategy {
    @Override
    public int getTotal(Registration reg) {
        int x = (int) (reg.getTotal()-20000);
        return Math.max(x,0);
        //return 20000;
    }
}
