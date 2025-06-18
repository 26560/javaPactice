import java.awt.event.*;

class ActionRes extends Action implements ActionListener{
    public ActionRes(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        clearAll();
    }
}