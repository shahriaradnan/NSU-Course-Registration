/**
 * Created by Adnan on 24/11/2015.
 */
public class DiscountMinority implements IDiscountStrategy {
    double per = .60;

    @Override
    public int getTotal(Registration reg) {
        double x = (int) reg.getTotal()*per;
        return (int) x;
    }
}
