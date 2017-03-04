import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Adnan on 24/11/2015.
 */
public class CourseFactory {
    static CourseFactory instance = null;
    IExtraFeeCalculator efCalculator;
    ArrayList<Course> cList = new ArrayList<>();

    CourseFactory(){
        makeCourses();
    }

    public static synchronized CourseFactory getInstance(){
        if(instance == null){
            instance = new CourseFactory();
        }
        return instance;
    }

    public IExtraFeeCalculator getExtraFeeCalcaluator() throws NullPointerException,SecurityException,IllegalAccessException,
            IOException,ClassNotFoundException,InstantiationException{

        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\acer\\Desktop\\327_a3\\src\\user.ini"));

        if(efCalculator == null){
            String className = p.getProperty("extra");
            efCalculator = (IExtraFeeCalculator) Class.forName(className).newInstance();
        }

        return efCalculator;
    }


    public void makeCourses(){
        String []ID = {"CSE 373","CSE 311","CSE 331", "CSE 327","CSE 326","CSE 283"};
        String []tit = {"Algorithm","Data Base","MicroProcessor", "Soft. Eng","Compiler","Electrical Lab1"};
        int []cred = {3,3,3,3,3,2};

        for(int i=0;i<ID.length;i++){
            Course course = new Course();
            course.setId(ID[i]);
            course.setTitle(tit[i]);
            course.setCredit(cred[i]);
            course.setTuitionPerCredit(4500);
            cList.add(course);
        }

    }

    public Course getCourse(String id){
        for(int i=0;i<cList.size();i++){
            if(cList.get(i).id.equals(id)){
                return cList.get(i);
            }
        }

        Course notFound = new Course();
        notFound.setId("-1");
        return notFound;
    }
}
