import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class calculatorLayout extends Frame implements ActionListener {
    public calculatorLayout(){
        super("calculator");
    }
    TextField textField1;
    StringBuilder stringHolder = new StringBuilder();
    Button button1 ,button2 ,button3 ,button4 ,button5 ,button6 ,button7 ,button8 ,button9 , button10, button11, button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25,button26;
    boolean flag = false;
    public void init(){
        setBounds(100,500,800,500);
        //设置布局
        setLayout(new BorderLayout());
        Panel p1 = new Panel(new BorderLayout());
        p1.setBackground(Color.RED);
        Panel p2 = new Panel(new GridLayout(5,5));
        p2.setBackground(Color.blue);
        button1 = new Button("(");
        button2 = new Button(")");
        button3 = new Button("%");
        button4 = new Button("^");
        button5 = new Button("|");
        button6 = new Button("7");
        button7 = new Button("8");
        button8 = new Button("9");
        button9 = new Button("/");
        button10 = new Button("&");
        button11 = new Button("4");
        button12 = new Button("5");
        button13 = new Button("6");
        button14 = new Button("x");
        button15 = new Button("=");
        button16 = new Button("1");
        button17 = new Button("2");
        button18 = new Button("3");
        button19 = new Button("-");
        button20 = new Button("<");
        button21 = new Button("0");
        button22 = new Button(".");
        button23 = new Button("go");
        button24 = new Button("+");
        button25 = new Button(">");
        button26 = new Button("clear");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);
        button17.addActionListener(this);
        button18.addActionListener(this);
        button19.addActionListener(this);
        button20.addActionListener(this);
        button21.addActionListener(this);
        button22.addActionListener(this);
        button23.addActionListener(this);
        button24.addActionListener(this);
        button25.addActionListener(this);
        button26.addActionListener(this);
        button26.setSize(5,5);

        textField1  = new TextField(stringHolder.toString());
        Font f = new Font("serif",Font.PLAIN,20);
        textField1.setFont(f);
        p1.add(textField1,BorderLayout.CENTER);
        p1.add(button26,BorderLayout.EAST);
        p2.add(button1);
        p2.add(button2);
        p2.add(button3);
        p2.add(button4);
        p2.add(button5);
        p2.add(button6);
        p2.add(button7);
        p2.add(button8);
        p2.add(button9);
        p2.add(button10);
        p2.add(button11);
        p2.add(button12);
        p2.add(button13);
        p2.add(button14);
        p2.add(button15);
        p2.add(button16);
        p2.add(button17);
        p2.add(button18);
        p2.add(button19);
        p2.add(button20);
        p2.add(button21);
        p2.add(button22);
        p2.add(button23);
        p2.add(button24);
        p2.add(button25);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('(');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button2){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append(')');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button3){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('%');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button4){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('^');
            textField1.setText(stringHolder.toString());
        }

        else if(e.getSource() == button5){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('|');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button6){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('7');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button7){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('8');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button8){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('9');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button9){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('/');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button10){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('&');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button11){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('4');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button12){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('5');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button13){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('6');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button14){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('*');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button15){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('=');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button16){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('1');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button17){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('2');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button18){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('3');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button19){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('-');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button20){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('<');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button21){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('0');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button22){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('.');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button23){
            flag = true;
            String ans = preOperation.mainOpt(stringHolder.toString());
            textField1.setText(ans);
        }
        else if(e.getSource() == button24){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('+');
            textField1.setText(stringHolder.toString());

        }
        else if(e.getSource() == button25){
            if(flag){
                stringHolder = new StringBuilder();
                flag = false;
            }
            stringHolder.append('>');
            textField1.setText(stringHolder.toString());
        }
        else if(e.getSource() == button26){
            stringHolder = new StringBuilder();
            textField1.setText("");
        }
    }
}


