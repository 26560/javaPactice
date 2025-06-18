import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

class ActionStart extends Action implements ActionListener{    
    Random rand = new Random();
    int z[] = new int[6];
    Timer timer = new Timer(1, null);

    public ActionStart(UI zhongjiangUi){
        super(zhongjiangUi);
    }

    public void actionPerformed(ActionEvent e){
        timer.start();
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tryNum = 0;
                start();
                if (tryNum++ >= 10000) {
                    timer.stop();
                    zhongjiangUi.c1.setEnabled(true);
                    zhongjiangUi.c2.setEnabled(true);
                }
                
            }
        });
    }

    public void start(){
        int num, inputNum, equalNumRed, equalNumBlue;
        int[] randNumStr = new int[zhongjiangUi.inputNum];
        clearRes();
        zhongjiangUi.c1.setEnabled(false);
        zhongjiangUi.c2.setEnabled(false);
        for (int tryNum=0; tryNum<10000; tryNum++){
        equalNumBlue = equalNumRed = 0;
        //根据模式判断是否生成输入数
        if (mode == 0){
            for (int i=0; i<zhongjiangUi.inputNum-1; i++){
                zhongjiangUi.textList1[i].setText(String.valueOf(rand.nextInt(33)+1));
            }
            zhongjiangUi.textList1[zhongjiangUi.inputNum-1].setText(String.valueOf(rand.nextInt(16)+1));
        }

        //设置得奖球
        for (int i=0; i<zhongjiangUi.inputNum - 1; i++){
            num = rand.nextInt(36)+1;
            zhongjiangUi.textList2[i].setText(String.valueOf(num));
            randNumStr[i] = num;
        }
        num = rand.nextInt(16)+1;
        zhongjiangUi.textList2[zhongjiangUi.inputNum - 1].setText(String.valueOf(num));
        randNumStr[zhongjiangUi.inputNum - 1] = num;
        
        //计算中奖数量
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
        zhongjiangUi.c1.setEnabled(true);
        zhongjiangUi.c2.setEnabled(true);
    }
}
