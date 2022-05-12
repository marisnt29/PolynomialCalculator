package operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MulOp implements BinaryOperation{
    @Override
    public Polynomial perform(Polynomial a, Polynomial b) {

        Map<Integer , Float> acc = new LinkedHashMap<>();
        List<Monomial> p1Mon = a.getMonomials();
        List<Monomial> p2Mon = b.getMonomials();

         for(Monomial m1 : p1Mon){
             for(Monomial m2 : p2Mon){
                   int newExp = m1.getExp()+m2.getExp();
                   if(acc.containsKey(newExp)){
                         acc.put(newExp,acc.get(newExp)+m1.getCoefficient()*m2.getCoefficient());
                   }
                   else{
                        acc.put(newExp,m1.getCoefficient()*m2.getCoefficient());
                   }
             }
         }

        List<Monomial> result = new ArrayList<>();
        acc.forEach( (exp, coefficient) -> {
            if(coefficient != 0) {
                result.add(new Monomial(coefficient, exp));
            }
        });

        return new Polynomial(result);
    }

}
