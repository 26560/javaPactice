import java.awt.event.*;
import javax.swing.*;

class ActionStop extends ActionStart{
    public ActionStop(UI zhongjiangUi, Timer timer){
        super(zhongjiangUi, timer);
    }

    public void actionPerformed(ActionEvent e){
        super.timer.stop();
        zhongjiangUi.c1.setEnabled(true);
        zhongjiangUi.c2.setEnabled(true);
    }
}