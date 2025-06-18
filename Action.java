class Action{
    UI zhongjiangUi = null;
    static byte mode = 1;
    
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


