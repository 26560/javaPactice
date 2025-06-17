import java.awt.event.*;
import java.util.Random;

class Action{
    UI zhongjiangUi = null;
    
    public Action(UI zhongjiangUi){
        this.zhongjiangUi = zhongjiangUi;
    }

    
    void clearAll(){
        clearInt();
        clearRes();
    }

    void clearRes(){
        for (int i=0; i<6; i++){
            zhongjiangUi.resultText[i].setText("");
        }
    }
    void clearInt(){
        for (int i=0; i<6; i++){
            zhongjiangUi.textList1[i].setText("");
            zhongjiangUi.textList2[i].setText("");
        } 
    }
}

class ActionStart extends Action implements ActionListener{    
    Random rand = new Random();

    public ActionStart(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        int equalNum = 0;
        String num, inputNum;
        clearRes();
        for (int i=0; i<6; i++){
            num = String.valueOf(rand.nextInt(2));
            zhongjiangUi.textList2[i].setText(num);
            inputNum = zhongjiangUi.textList1[i].getText();
            if(num.equals(inputNum)){
                equalNum += 1;
            }
        }
        System.out.println(equalNum);
        if (equalNum>=3){
            zhongjiangUi.resultText[equalNum - 3].setText("True");
        }
    }
}

class ActionStop extends Action implements ActionListener{
    public ActionStop(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        clearAll();
    }
}