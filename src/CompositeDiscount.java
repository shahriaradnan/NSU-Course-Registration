import java.util.ArrayList;

/**
 * Created by Adnan on 24/11/2015.
 */
public abstract class CompositeDiscount implements IDiscountStrategy {
    ArrayList<IDiscountStrategy> idArr = new ArrayList<>();

    public void add(IDiscountStrategy ids){
        idArr.add(ids);
    }

    @Override
    public abstract int getTotal(Registration reg);
}
