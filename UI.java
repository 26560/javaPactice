import java.awt.*;
import java.awt.event.*;

class UI{
    int inputNum = 6;
    TextField textList1[] = new TextField[inputNum]; 
    TextField textList2[] = new TextField[inputNum]; 
    String resultPriList[] = {"6中3", "6中4", "6中5", "6中6", "Drawing", "Years"};
    int resultNum = resultPriList.length;
    TextField resultText[] = new TextField[resultNum];
    public UI(){

        Font defaultFont = Font.decode(null);
        System.out.println(defaultFont);

        //生成框架
        Frame frame = new Frame("李炜豪_20230154005");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(5,1));

        //生成面板,设置布局
        Panel p1 = new Panel(new FlowLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p2_1 = new Panel(new GridLayout(1,7));
        Panel p2_2 = new Panel(new GridLayout(1,7));
        Panel p3 = new Panel(new FlowLayout());
        Panel p4 = new Panel(new GridLayout(2,1));
        Panel p4_1 = new Panel(new GridLayout(1,6));
        Panel p4_2 = new Panel(new GridLayout(1,6));
        Panel p5 = new Panel(new FlowLayout());



        //顶部复选框
        CheckboxGroup cg = new CheckboxGroup();
        Checkbox c1 = new Checkbox("快速选择",cg, false);
        Checkbox c2 = new Checkbox("个人的",cg, true);
        p1.add(c1);
        p1.add(c2);
        frame.add(p1);



        //第二行输入
        Label l1 = new Label("你的输入");
        Label l2 = new Label("中奖数");
        p2_1.add(l1);
        p2_2.add(l2);
        
        for (int i=0; i<inputNum; i++){
            textList1[i] = new TextField(1);
            p2_1.add(textList1[i]);
        }

        for (int i=0; i<inputNum; i++){
            textList2[i] = new TextField(1);
            textList2[i].setEnabled(false);
            p2_2.add(textList2[i]);
        }
        p2.add(p2_1);
        p2.add(p2_2);
        frame.add(p2);



        //第三行控制按钮
        String buttonLabel[] = {"停止", "开始", "重置"};
        int ButtonNum = buttonLabel.length;
        Button buttonList[] = new Button[ButtonNum];  
        for (int i=0; i<ButtonNum; i++){
            buttonList[i] = new Button(buttonLabel[i]);
            p3.add(buttonList[i]);
        }
        //监听器
        buttonList[1].addActionListener(new ActionStart(this));
        buttonList[2].addActionListener(new ActionStop(this));
        frame.add(p3);




        //第四行结果输出
        Label resultProLabel[] = new Label[resultNum];
        for (int i=0; i<resultPriList.length; i++){
            resultProLabel[i] = new Label(resultPriList[i]);
            resultText[i] = new TextField();
            if (i<3){
                p4_1.add(resultProLabel[i]);
                p4_1.add(resultText[i]);
            }
            else{
                p4_2.add(resultProLabel[i]);
                p4_2.add(resultText[i]);
            }
        }
        p4.add(p4_1);
        p4.add(p4_2);
        frame.add((p4));
        frame.add(p5);


        //添加关闭监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
