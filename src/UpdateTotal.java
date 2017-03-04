import java.io.IOException;

/**
 * Created by Adnan on 25/11/2015.
 */
public class UpdateTotal extends RegistrationJFrame implements Alarm {
    @Override
    public void onAlarmEvent(Registration reg, String source) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        if(source.equals("GrandTotal")){
            textField5.setText(Double.toString(reg.getGrandTotal()));
        }
    }
}
