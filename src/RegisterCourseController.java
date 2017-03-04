import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Adnan on 24/11/2015.
 */
public class RegisterCourseController {
    Registration reg = new Registration();
    CourseFactory cf = new CourseFactory();

    public void makeNewRegistration(){
        if(!reg.courseList.isEmpty()){
            reg.courseList.clear();
        }
    }

    public Course addCourse(String id){
        return reg.addCourse(cf.getCourse(id));
    }
    public void discount(ArrayList<String> strategies,String policy){

    }

    public Registration getRegistration(){
        return reg;
    }

    public int getDiscount(ArrayList<String> strategies,String policy)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        return reg.getDiscount(strategies,policy);
    }
}
