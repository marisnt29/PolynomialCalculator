package operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivOp implements BinaryOperation{


    @Override
    public Polynomial perform(Polynomial a, Polynomial b) {

        List<Monomial> D = a.getMonomials();
        List<Monomial> I =b.getMonomials();
        List<Monomial> C = new ArrayList<>();

        BinaryOperation addOp = new AddOp();
        BinaryOperation  subOp= new SubOp();
        BinaryOperation mulOp = new MulOp();

        while(a.getMonomials().isEmpty() == false && D.get(0).getExp()>= I.get(0).getExp() ){

              Monomial termen = new Monomial (D.get(0).getCoefficient()/I.get(0).getCoefficient(),D.get(0).getExp()-I.get(0).getExp());

              Polynomial polyTermen = new Polynomial(Arrays.asList(termen));
              C.add(termen);

              Polynomial aux = mulOp.perform(b,polyTermen);
              a = subOp.perform(a,aux);

              D = a.getMonomials();
              I = b.getMonomials();



        }

        return new Polynomial(C);
    }
}
