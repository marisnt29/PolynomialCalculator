package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewPB extends JFrame{
    private static final String[] opStrings = { "Adunare", "Scadere", "Inmultire", "Impartire", "Derivare" , "Integrare" };
    private JLabel labelP1 = new JLabel("Polynom1");
    private JLabel labelP2 = new JLabel("Polynom2:");
    private JLabel labelOp = new JLabel("Alege operatia");
    private JLabel labelRes = new JLabel("Rezultat:");
    private JComboBox opList = new JComboBox(opStrings);
    private JTextField textP1 = new JTextField();
    private JTextField textP2 = new JTextField();
    private JButton butonCalc = new JButton("Calculeaza");
    private JTextArea textarea = new JTextArea();
    private JLabel labelNote = new JLabel("Note : Operatiile pe un singur polinom se vor efectua asupra Polynom1");


    public  ViewPB() {

         this.setSize(550,450);


         JPanel pp = new JPanel(); //panou principal
          pp.setBounds(20, 10, 511, 256);
          pp.setLayout(null);

        labelP1.setBounds(10, 10, 91, 29);
        labelP1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pp.add(labelP1);

        textP1.setBounds(78, 10, 257, 21);
        pp.add(textP1);

        labelP2.setBounds(10, 45, 62, 15);
        labelP2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pp.add(labelP2);

        textP2.setBounds(78, 45, 257, 21);
        pp.add(textP2);

        labelOp.setBounds(361, 18, 147, 13);
        labelOp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pp.add(labelOp);

        opList.setBounds(341, 43, 147, 21);
        opList.setSelectedIndex(0);
        pp.add(opList);

        butonCalc.setBounds(10, 84, 125, 29);
        butonCalc.setBackground(UIManager.getColor("Button.shadow"));
        pp.add(butonCalc);

        textarea.setBounds(10, 154, 465, 71);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        pp.add(textarea);

        labelRes.setBounds(20, 131, 111, 13);
        labelRes.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pp.add(labelRes);



        labelNote.setBounds(20, 190, 500, 100);
        labelNote.setFont(new Font("Tahoma",Font.PLAIN,13));
        pp.add(labelNote);


        this.setTitle("Aplicatie");
        this.setContentPane(pp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }



    public void addActionListenerForButtonCalc(ActionListener al) {
        butonCalc.addActionListener(al);
    }


    public void showError(String text) {
        System.out.println(text);
    }

    public void setTextOfTextArea(String text){
        textarea.setText(text);
    }

    String getImputP1() {
        return textP1.getText();
    }

        String getImputP2() {
        return textP2.getText();
    }

    String getOp() {
        return (String) opList.getSelectedItem();
    }
}