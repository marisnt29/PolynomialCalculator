package GUI;

import model.Monomial;
import model.Polynomial;
import operations.*;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerPB  {

    private static final String PATTERN = "(\\s*[+-]*\\s*\\d+x\\^\\d+)";
    private ViewPB viewpb;

    ControllerPB(GUI.ViewPB view) {
        viewpb = view;

        //adaugam listenere la view
        view.addActionListenerForButtonCalc(new CalcListener());

    }

    class CalcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP1 = new String();
            String userInputP2 = new String();
            String operatie = new String();
            operatie = viewpb.getOp();
            userInputP1 = viewpb.getImputP1();
            userInputP2 = viewpb.getImputP2();
            List<Monomial> monomials1 = new ArrayList<>();
            List<Monomial> monomials2 = new ArrayList<>();

            BinaryOperation addOp = new AddOp();
            BinaryOperation  subOp= new SubOp();
            BinaryOperation mulOp = new MulOp();
            BinaryOperation divOp = new DivOp();
            UnaryOperation intOp = new IntegrateOp();
            UnaryOperation derOp = new DerivOp();





            try {


//                Pattern p = Pattern.compile(PATTERN);
//                Matcher m = p.matcher(userInputP1);
//                while(m.find()) {
//                    monomials1.add(new Monomial(m.group()));
//                }
//
//                m = p.matcher(userInputP2);
//
//                while(m.find()) {
//                    monomials2.add(new Monomial(m.group()));
//                }
//
//                Polynomial P1 = new Polynomial(monomials1);
//                Polynomial P2 = new Polynomial(monomials2);

                  Polynomial P1 = new Polynomial(userInputP1);
                  Polynomial P2 = new Polynomial(userInputP2);

                switch(operatie){
                    case "Adunare":
                          Polynomial result1 = addOp.perform(P1,P2);
                        System.out.println(P1.toString());
                        System.out.println(P2.toString());
                           System.out.println(result1.toString());
                           viewpb.setTextOfTextArea(result1.toStringForCalc());
                           break;

                    case "Scadere":
                          Polynomial result2 = subOp.perform(P1,P2);
                        viewpb.setTextOfTextArea(result2.toStringForCalc());
                        break;

                    case "Inmultire":
                          Polynomial result3 = mulOp.perform(P1,P2);
                        viewpb.setTextOfTextArea(result3.toStringForCalc());
                        break;

                    case "Impartire":
                         Polynomial result4 = divOp.perform(P1,P2);
                        viewpb.setTextOfTextArea(result4.toStringForCalc());
                        break;

                    case "Derivare":
                          Polynomial result5 = derOp.perform(P1);
                        viewpb.setTextOfTextArea(result5.toStringForCalc());
                        break;

                    case "Integrare":
                        Polynomial result6 = intOp.perform(P1);
                        viewpb.setTextOfTextArea(result6.toStringForCalc());
                        break;

                }


            } catch (Exception exp) {
                viewpb.showError("Bad input");
                viewpb.setTextOfTextArea("ERROR!! BAD INPUT)");
            }
        }
    }

}
