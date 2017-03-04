import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Adnan on 24/11/2015.
 */
public class Registration {
    int discount = 0;
    //int presenttotal=0,newtotal=0;

    ArrayList<Course> courseList = new ArrayList<>();
    ArrayList<Alarm> alarmList = new ArrayList<>();
    CompositeDiscount compositeDiscount;
    IDiscountStrategy iDiscountStrategy;

    Registration(){
        addAlarmListener(new AlarmBeep());
    }

    public void addAlarmListener(Alarm lis){
        alarmList.add(lis);
    }

    public void publishAlarmListener(String source) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        for(int i=0;i<alarmList.size();i++){
            alarmList.get(i).onAlarmEvent(this,source);
        }
    }


    public Course addCourse(Course course){
        courseList.add(course);
        return course;
    }

    public double getTotal(){
        double total = 0;
        for(int i=0;i<courseList.size();i++){
            total += courseList.get(i).getSubTotal();
        }
        return total;
    }

    public int getGrandTotal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        publishAlarmListener("GrandTotal");
        return (int)this.getTotal() + this.getExtraFeeAmount()-discount;
    }

    public int getExtraFeeAmount() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        IExtraFeeCalculator iefc = CourseFactory.getInstance().getExtraFeeCalcaluator();
        return iefc.getExtraAmount((int)this.getTotal());
    }

    public int getDiscount(ArrayList<String> strategies,String policy)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        Class<?> pol = Class.forName(policy);
        compositeDiscount = (CompositeDiscount) pol.newInstance();
        for(int i=0;i<strategies.size();i++){
            Class<?> cls = Class.forName(strategies.get(i));
            iDiscountStrategy = (IDiscountStrategy) cls.newInstance();
            //Object cls = (IDiscountStrategy)Class.forName(strategies.get(i)).newInstance();
            //IDiscountStrategy clll = (IDiscountStrategy) cls;
            //compositeDiscount.add((IDiscountStrategy)cls);
            compositeDiscount.add(iDiscountStrategy);
        }

        discount = compositeDiscount.getTotal(this);
        publishAlarmListener("Discount");
        return discount;
    }
}
