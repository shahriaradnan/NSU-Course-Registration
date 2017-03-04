/**
 * Created by Adnan on 24/11/2015.
 */
public class DiscountCGPA implements IDiscountStrategy {
    double percentage = .5;

    @Override
    public int getTotal(Registration reg) {
        double x = reg.getTotal()*percentage;
        return (int) x;
    }
}
