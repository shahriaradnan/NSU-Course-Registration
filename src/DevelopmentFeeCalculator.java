import static java.lang.Math.ceil;

/**
 * Created by Adnan on 25/11/2015.
 */
public class DevelopmentFeeCalculator implements IExtraFeeCalculator {
    @Override
    public int getExtraAmount(int courseTotal) {
        return (int)ceil(courseTotal* 0.1);
    }
}
