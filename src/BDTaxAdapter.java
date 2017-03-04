import static java.lang.Math.ceil;

/**
 * Created by Adnan on 24/11/2015.
 */
public class BDTaxAdapter extends BDTaxCalculator implements IExtraFeeCalculator {
    @Override
    public int getExtraAmount(int courseTotal) {
        return (int) ceil(calculateVATAmount(courseTotal));
    }
}
