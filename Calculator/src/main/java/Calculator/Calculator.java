package Calculator.src.main.java.Calculator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * （1）具备基本的加减乘除功能；支持由括号和运算符组成的表达式运算：要求转化为后缀字符串用栈计算 （2）使用GUI界面元素设计用户友好的界面；无需支持浮点数
 * （3）能够存储多个计算结果，并提取出来作为下一个计算的操作数； （4）能够处理计算过程中的异常情况；除0错误、溢出错误
 * （5）使用Eclipse、NetBeans或Intellj作为开发环境，使用Maven管理项目，使用Git进行源代码控制；
 * （6）在实验报告中，对软件需求进行规范、详细的描述。
 */
public class Calculator extends JFrame {
    private String expression;
    static int count;
    boolean div0;
    boolean notNum;
    boolean shift;
    boolean left;
    boolean right;
    public Calculator() {
        count = 0;
        div0 = false;
        notNum = false;
        setTitle("Calculator by zura");
        expression = "";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultLookAndFeelDecorated(true);
        setSize(450, 450);
        setMinimumSize(new Dimension(450, 450));
        JPanel view = new JPanel();
        JPanel interaction = new JPanel();
        JPanel history = new JPanel();
        //getContentPane().setLayout(new FlowLayout());
        getContentPane().add(view, BorderLayout.NORTH);
        getContentPane().add(interaction, BorderLayout.CENTER);
        getContentPane().add(history, BorderLayout.EAST);
        JTextField display = new JTextField(30);
        display.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
                display.setText(expression);
                //JOptionPane.showMessageDialog(null, expression);
                int keyChar = e.getKeyChar();
                //System.out.println(keyChar);				
				if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)){
                    expression += e.getKeyText(keyChar);
                    //display.setText(expression);
                }else if(keyChar == KeyEvent.VK_BACK_SPACE && expression.length()!=0){
                    expression = expression.substring(0, expression.length()-1);
                    //display.setText(expression);
                }
                else{
					e.consume();
                }
                //display.setText(expression);
            }
            public void keyPressed(KeyEvent e){
                display.setText(expression);
                int i = e.getKeyCode();
                switch (i) {
                    case KeyEvent.VK_SHIFT:
                        shift = true;
                        break;
                    case KeyEvent.VK_9:
                        left = true;
                        break;
                    case KeyEvent.VK_0:
                        right = true;
                        break;
                    default:
                        break;
                }
                //JOptionPane.showMessageDialog(null, "shift"+shift+"right"+right+"left"+left);
                if(shift == true && left == true && right == false)
                {
                    expression += "(";
                    //display.setText(expression);
                }
                else if(shift == true && left == false && right == true)
                {
                    expression += ")";
                    //display.setText(expression);
                }
                display.setText(expression);
            }
            public void keyReleased(KeyEvent e)
            {
                display.setText(expression);
                int i = e.getKeyCode();
                switch (i) {
                    case KeyEvent.VK_SHIFT:
                        shift = false;
                        //JOptionPane.showMessageDialog(null, "shift"+shift+"right"+right+"left"+left);
                        break;
                    case KeyEvent.VK_9:
                        left = false;
                        break;
                    case KeyEvent.VK_0:
                        right = false;
                        break;
                    default:
                        break;
                }
                //display.setText(expression);
            }
		});
        view.setLayout(new FlowLayout());
        view.add(display);
        JButton backspaceButton = new JButton("⬅");
        backspaceButton.addActionListener(e -> {
            if(expression.length()!=0){
            expression = expression.substring(0, expression.length()-1);
            display.setText(expression);
            }
        });
        JButton clearButton = new JButton("清除");
        clearButton.addActionListener(e -> {
            expression="";
            display.setText(expression);
        });
        view.add(backspaceButton);
        view.add(clearButton);

        JButton[] hisButtons = new JButton[5];
        history.setLayout(new GridLayout(5,1));
        for(int i=0;i<5;i++)
        {
            hisButtons[i] = new JButton("     ");
            hisButtons[i].addActionListener(e -> {
                String x = ((JButton)e.getSource()).getText();
                Double res = Double.parseDouble(x);
                Integer resI = res.intValue();
                expression += resI.toString();
                display.setText(expression);
                JOptionPane.showMessageDialog(null, "本程序只接受整数输入。");
            });
            history.add(hisButtons[i]);
        }

        JButton b1 = new JButton("1");
        b1.addActionListener(e -> {
            expression += '1';
            display.setText(expression);
        });
        JButton b2 = new JButton("2");
        b2.addActionListener(e -> {
            expression += '2';
            display.setText(expression);
        });
        JButton b3 = new JButton("3");
        b3.addActionListener(e -> {
            expression += '3';
            display.setText(expression);
        });
        JButton b4 = new JButton("4");
        b4.addActionListener(e -> {
            expression += '4';
            display.setText(expression);
        });
        JButton b5 = new JButton("5");
        b5.addActionListener(e -> {
            expression += '5';
            display.setText(expression);
        });
        JButton b6 = new JButton("6");
        b6.addActionListener(e -> {
            expression += '6';
            display.setText(expression);
        });
        JButton b7 = new JButton("7");
        b7.addActionListener(e -> {
            expression += '7';
            display.setText(expression);
        });
        JButton b8 = new JButton("8");
        b8.addActionListener(e -> {
            expression += '8';
            display.setText(expression);
        });
        JButton b9 = new JButton("9");
        b9.addActionListener(e -> {
            expression += '9';
            display.setText(expression);
        });
        JButton b0 = new JButton("0");
        b0.addActionListener(e -> {
            expression += '0';
            display.setText(expression);
        });
        JButton bPlus = new JButton("+");
        bPlus.addActionListener(e -> {
            expression += '+';
            display.setText(expression);
        });
        JButton bMinus = new JButton("-");
        bMinus.addActionListener(e -> {
            expression += '-';
            display.setText(expression);
        });
        JButton bMul = new JButton("×");
        bMul.addActionListener(e -> {
            expression += '*';
            display.setText(expression);
        });
        JButton bDiv = new JButton("÷");
        bDiv.addActionListener(e -> {
            expression += '/';
            display.setText(expression);
        });
        JButton bNeg = new JButton("+/-");
        bNeg.addActionListener(e -> {
            int len = expression.length();
            String og = expression.substring(0, len-1);
            String edit = expression.substring(len-1, len);
            if(edit.equals("+") == false && edit.equals("-") == false 
             && edit.equals("*") == false && edit.equals("/") == false
             && edit.equals("(") == false && edit.equals(")") == false 
             && edit.equals("0") == false)
             {
                expression = og + "(0-" + edit +")";
             }
            display.setText(expression);
        });
        JButton bEql = new JButton("=");
        bEql.addActionListener(e -> {
            if(expression == "")
            {
                JOptionPane.showMessageDialog(null, "您还什么都没有输入。");
                return;
            }
            if(chkStr(expression) == false)
            {
                JOptionPane.showMessageDialog(null, "奇怪的字符串出现了！");
            }
            else
            {
                String cc = postfix();
                Double res;
                if(notNum == true)
                {
                    res = 0.0;
                    JOptionPane.showMessageDialog(null, "奇怪的字符出现了！");
                }
                else
                    res = expCalc(cc);
                if(div0 == true)
                {
                    JOptionPane.showMessageDialog(null, "除数不可以为0！");
                    res = 0.0;
                }
                display.setText(res.toString());
                Integer temp = res.intValue();
                expression = temp.toString();
                System.out.println(res);
                hisButtons[count].setText(res.toString());
                count++;
                if(count >= 5)
                {
                    count = 0;
                }
            }
        });
        interaction.setLayout(new GridLayout(4, 4));
        interaction.add(b1);
        interaction.add(b2);
        interaction.add(b3);
        interaction.add(bPlus);
        interaction.add(b4);
        interaction.add(b5);
        interaction.add(b6);
        interaction.add(bMinus);
        interaction.add(b7);
        interaction.add(b8);
        interaction.add(b9);
        interaction.add(bMul);
        interaction.add(bNeg);
        interaction.add(b0);
        interaction.add(bEql);
        interaction.add(bDiv);
    }

    private boolean isNum(char c){
        return c>=48 && c<=57;
    }

    private boolean chkStr(String x)
    {
        //开头和结尾不能是+-*/，开头不能是),结尾不能是(
        //通篇不能出现运算符以外的内容
        //两个符号不能挨在一起
        char [] c = x.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            if(i==0 || i==c.length-1)
            {
                if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/')
                    return false;
                if(i==0 && c[i]==')')
                    return false;
                if(i==c.length-1 && c[i]=='(')
                    return false;
            }
            if(isNum(c[i]) == false && 
            c[i] != '+' && c[i] != '-' && c[i] !='*' && c[i]!='/'&&
            c[i]!='('&&c[i]!=')'){
                System.out.println(c[i]);
                return false;
            }
            if((c[i] == '+' || c[i] == '-' || c[i] =='*' || c[i]=='/' || c[i]=='(')&&
               (c[i+1] == '+' || c[i+1] == '-' || c[i+1] =='*' || c[i+1]=='/' || c[i+1]==')'))
                return false;
        }
        return true;
    }

    private String postfix()
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> opt = new Stack();
        char [] c = this.expression.toCharArray();
        //遍历中缀表达式，请查看上面的规则
        for (int i=0;i<c.length;i++) {
            if (isNum(c[i])){
                postfix.append(c[i]);
                int flag = i;
                //如果当前字符为数字且下一位不数字，或当前数字已是中缀表达式字符串最后一位，在多位数后添加" "来分隔
                if ( (i<c.length-1&&!isNum(c[flag+1]))|| i == c.length-1)
                    postfix.append(" ");
                continue;
            }
            if (c[i]=='('||c[i]=='*'||c[i]=='/'){
                opt.push(c[i]);
                continue;
            }
            if (c[i]==')'){
                while ((!opt.isEmpty())) {
                    if (opt.peek()=='('){
                        opt.pop();
                        continue;
                    }
                    postfix.append(opt.pop());
                }
                continue;
            }
            if (c[i]=='+'||c[i]=='-'){
                while ((!opt.isEmpty())&&opt.peek()!='('){
                    postfix.append(opt.pop());
                }
                opt.push(c[i]);
                continue;
            }
            notNum = true;
            return "Non char error";
        }

        //当遍历完中缀表达式，把此时符号栈的元素弹出，添加到后缀表达式
        while (!opt.isEmpty()){
            postfix.append(opt.pop());
        }
        return postfix.toString();
        // 版权声明：本文为CSDN博主「peng月月」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
        // 原文链接：https://blog.csdn.net/mlvper/article/details/97120107
    }
    private double expCalc(String expression)
    {
        Stack<Double> num = new Stack<>();
        StringBuilder  sb = new StringBuilder();
        char[] c = expression.toCharArray();
        for (int i = 0;i< c.length;i++) {
            if (isNum(c[i])) {
                sb.append(c[i]);
                //如果当前字符已经是表达式字符串最后一位，直接放入操作数栈
                if (i+1 == c.length) {
                    num.push(Double.parseDouble(sb.toString()));
                    continue;
                }
                //判断是否为多位数，如果当前字符下一位为设置的" "标记,就截取到当前字符
                if (c[i+1]==" ".charAt(0)) {
                    num.push(Double.parseDouble(sb.toString()));
                    sb.delete(0,sb.length());
                    continue;
                }
                continue;
            }
            if (c[i]=='+') {
                num.push(num.pop()+num.pop());
            }
            if (c[i] == '-') {
                double num1 = num.pop();
                double num2 = num.pop();
                num.push(num2-num1);
            }
            if (c[i] == '*') {
                num.push(num.pop()*num.pop());
            }
            if (c[i] == '/') {
                double num1 = num.pop();
                double num2 = num.pop();
                if(num1 == 0)
                {
                    div0 = true;
                    return -1;
                }
                num.push(num2/num1);
            }
        }
        //扫面完后缀表达式，操作数栈只剩下一个元素，就是计算的结果
        //System.out.println("result is ："+num.pop());
        return num.pop();
        // 版权声明：本文为CSDN博主「peng月月」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
        // 原文链接：https://blog.csdn.net/mlvper/article/details/97120107
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calculator c = new Calculator();
        c.setVisible(true);
    }
}