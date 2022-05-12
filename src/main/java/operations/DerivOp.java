package operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DerivOp implements UnaryOperation {


    @Override
    public Polynomial perform(Polynomial a) {
        Map<Integer, Float> acc = new LinkedHashMap<>();
        List<Monomial> monomials = a.getMonomials();

        for(Monomial mon: monomials) {
            if(mon.getExp() != 0) {
                if(acc.containsKey(mon.getExp() - 1)) {
                    acc.put(mon.getExp() - 1, acc.get(mon.getExp() - 1) + mon.getExp()*mon.getCoefficient());
                } else {
                    acc.put(mon.getExp() - 1, mon.getCoefficient() * mon.getExp());
                }
            }
        }

        List<Monomial> resultList = new ArrayList<>();
        acc.forEach( (exp, coefficient) -> {
            if(coefficient != 0) {
                resultList.add(new Monomial(coefficient, exp));
            }
        });

        return new Polynomial(resultList);
    }
}
