import java.awt.event.*;

class ActionStop extends ActionStart{
    public ActionStop(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Stopping the timer...");
        super.timer.stop();
    }
}