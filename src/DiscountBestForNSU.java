/**
 * Created by Adnan on 25/11/2015.
 */
public class DiscountBestForNSU extends CompositeDiscount {
    public int getTotal(Registration reg){
        if(idArr.isEmpty())   return 0;
        int mn = Integer.MAX_VALUE;
        for(int i=0;i<idArr.size();i++){
            mn = Math.min(mn,idArr.get(i).getTotal(reg));
        }
        return mn;
    }
}
