/**
 * Created by Adnan on 25/11/2015.
 */
public class DiscountBestForStudent extends CompositeDiscount {
    public int getTotal(Registration reg){
        if(idArr.isEmpty()) return 0;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<idArr.size();i++){
            mx = Math.max(mx,idArr.get(i).getTotal(reg));
        }
        return mx;
    }
}
