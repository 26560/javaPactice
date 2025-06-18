import java.awt.event.*;
import javax.swing.*;

class ActionRes extends ActionStop{
    public ActionRes(UI zhongjiangUi, Timer timer){
        super(zhongjiangUi, timer);
    }

    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        clearAll();
    }
}