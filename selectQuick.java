import java.awt.event.*;

class selectQuick extends Action implements ActionListener{
    public selectQuick(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        mode = 0; 
    }
}

class selectPerson extends Action implements ActionListener{
    public selectPerson(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        mode = 1; 
    }
}