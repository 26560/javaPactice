import javax.swing.*;
import java.awt.*;


class UI{
    int inputNum = 8;
    JRadioButton c1 = new JRadioButton("快速选择", false);
    JRadioButton c2 = new JRadioButton("个人的", true);
    JTextField textList1[] = new JTextField[inputNum];
    JTextField textList2[] = new JTextField[inputNum];
    String resultPriList[] = {"一等奖", "二等奖", "三等奖", "四等奖", "五等奖", "六等奖"};
    int resultNum = resultPriList.length;
    JTextField resultText[] = new JTextField[resultNum];
    public UI(){

        Font defaultFont = Font.decode(null);
        System.out.println(defaultFont);

        //生成框架
        JFrame frame = new JFrame("李炜豪_20230154005");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(5,1));

        //生成面板,设置布局
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new GridLayout(2,1));
        JPanel p2_1 = new JPanel(new GridLayout(1,7));
        JPanel p2_2 = new JPanel(new GridLayout(1,7));
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new GridLayout(2,1));
        JPanel p4_1 = new JPanel(new GridLayout(1,6));
        JPanel p4_2 = new JPanel(new GridLayout(1,6));
        JPanel p5 = new JPanel(new FlowLayout());



        //顶部复选框
        ButtonGroup cg = new ButtonGroup();
        c1.addActionListener(new selectQuick(this));
        c2.addActionListener(new selectPerson(this));
        cg.add(c1);
        cg.add(c2);
        p1.add(c1);
        p1.add(c2);
        frame.add(p1);



        //第二行输入
        JLabel l1 = new JLabel("你的输入");
        JLabel l2 = new JLabel("中奖数");
        p2_1.add(l1);
        p2_2.add(l2);
        
        int redNum = 7;
        for (int i=0; i<inputNum; i++){
            textList1[i] = new JTextField(1);
            if (i<redNum){
                textList1[i].setBackground(Color.red);
            }
            else{
                textList1[i].setBackground(Color.blue);
            }
            p2_1.add(textList1[i]);
        }

        for (int i=0; i<inputNum; i++){
            textList2[i] = new JTextField(1);
            textList2[i].setEnabled(false);
            if (i<redNum){
                textList2[i].setBackground(Color.red);
            }
            else{
                textList2[i].setBackground(Color.blue);
            }
            p2_2.add(textList2[i]);
        }
        p2.add(p2_1);
        p2.add(p2_2);
        frame.add(p2);



        //第三行控制按钮
        String buttonLabel[] = {"停止", "开始", "重置"};
        int ButtonNum = buttonLabel.length;
        JButton buttonList[] = new JButton[ButtonNum];
        for (int i=0; i<ButtonNum; i++){
            buttonList[i] = new JButton(buttonLabel[i]);
            p3.add(buttonList[i]);
        }
        //监听器
        buttonList[0].addActionListener(new ActionStop(this));
        buttonList[1].addActionListener(new ActionStart(this));
        buttonList[2].addActionListener(new ActionRes(this));
        frame.add(p3);




        //第四行结果输出
        JLabel resultProLabel[] = new JLabel[resultNum];
        for (int i=0; i<resultPriList.length; i++){
            resultProLabel[i] = new JLabel(resultPriList[i]);
            resultText[i] = new JTextField();
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


        //关闭窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
