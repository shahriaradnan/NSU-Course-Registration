import java.io.IOException;
/**
 * Created by Adnan on 24/11/2015.
 */
public interface Alarm {
    public void onAlarmEvent(Registration reg,String source) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException;
}
