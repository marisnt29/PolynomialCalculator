package operations;

import model.Polynomial;
import model.Monomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubOp implements BinaryOperation {
    @Override
    public Polynomial perform(Polynomial a, Polynomial b) {
        Map<Integer, Float> acc = new LinkedHashMap<>();
        accumulateDescazut(acc, a);
        accumulateScazator(acc, b);
        List<Monomial> monomials = new ArrayList<>();
        acc.forEach((exp, coefficient) -> {
            if (coefficient != 0) {
                monomials.add(new Monomial(coefficient, exp));
            }
        });
        return new Polynomial(monomials);
    }



    private void accumulateDescazut(Map<Integer, Float> acc, Polynomial a) {
        for (Monomial monomial: a.getMonomials()) {
            acc.put(monomial.getExp(), monomial.getCoefficient());
        }
    }

    private void accumulateScazator(Map<Integer, Float> acc, Polynomial a) {
        for (Monomial monomial: a.getMonomials()) {
            if(acc.containsKey(monomial.getExp())) {
                acc.put(monomial.getExp(), acc.get(monomial.getExp()) - monomial.getCoefficient());
            } else {
                acc.put(monomial.getExp(), monomial.getCoefficient()*(-1));
            }
        }
    }

}
