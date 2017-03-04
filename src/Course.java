/**
 * Created by Adnan on 24/11/2015.
 */
public class Course {
    String id;
    String title;
    int credit;
    double tuitionPerCredit;

    public void setId(String id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public  void setTuitionPerCredit(double tuitionPerCredit){
        this.tuitionPerCredit = tuitionPerCredit;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public int getCredit(){
        return this.credit;
    }

    public double getTuitionPerCredit(){
        return tuitionPerCredit;
    }

    public double getSubTotal(){
        return credit*tuitionPerCredit;
    }
}
