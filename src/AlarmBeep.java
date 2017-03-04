import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Adnan on 24/11/2015.
 */
public class AlarmBeep extends JFrame implements Alarm {
    @Override
    public void onAlarmEvent(Registration reg,String source) {
        if(source.equals("Discount"))
            Toolkit.getDefaultToolkit().beep();
    }
}
