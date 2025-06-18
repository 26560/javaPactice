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
        for (int i=0; i<zhongjiangUi.inputNum; i++){
            zhongjiangUi.textList1[i].setText("");
            zhongjiangUi.textList2[i].setText("");
        } 
    }
}

class ActionStart extends Action implements ActionListener{    
    Random rand = new Random();
    int z[] = new int[6];

    public ActionStart(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        int num, inputNum, equalNumRed, equalNumBlue;
        equalNumBlue = equalNumRed = 0;
        int[] randNumStr = new int[zhongjiangUi.inputNum];
        clearRes();
        for (int i=0; i<zhongjiangUi.inputNum; i++){
            num = rand.nextInt(2)+1;
            zhongjiangUi.textList2[i].setText(String.valueOf(num));
            randNumStr[i] = num;
        }
        
        for (int i=0; i<zhongjiangUi.inputNum-1; i++){
            inputNum = Integer.valueOf(zhongjiangUi.textList1[i].getText());
            for (int j=0; j<zhongjiangUi.inputNum - 1; j++){
                if (inputNum == randNumStr[j]){
                    randNumStr[j] = 0; 
                    equalNumRed++;
                    break;
                }
            }
        }
        if (Integer.valueOf(zhongjiangUi.textList1[zhongjiangUi.inputNum-1].getText()) == randNumStr[zhongjiangUi.inputNum - 1]){
            equalNumBlue = 1;
        }

        System.out.println(equalNumRed);
        System.out.println(equalNumBlue);

        switch (equalNumRed) {
            case 6:
                if (equalNumBlue == 1){
                    z[0]++;
                } else {
                    z[1]++;
                }
                break;
            case 5:
                if (equalNumBlue == 1){
                    z[2]++;
                } else {
                    z[3]++;
                }
                break;
            case 4:
                if (equalNumBlue == 1){
                    z[3]++;
                } else {
                    z[4]++;
                }
                break;
            case 3:
                if (equalNumBlue == 1){
                    z[4]++;
                }
                break;
            default:
                if (equalNumBlue == 1){
                    z[5]++;
                }
                break;
        }

        for (int i=0; i<6; i++){
            zhongjiangUi.resultText[i].setText(String.valueOf(z[i]));
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