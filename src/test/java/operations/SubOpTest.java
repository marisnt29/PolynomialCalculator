package operations;

import model.Monomial;
import model.Polynomial;

import operations.BinaryOperation;
import operations.SubOp;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubOpTest  {
     @Test
    public void perform(){
        Polynomial a = new Polynomial(Arrays.asList(new Monomial(5, 3)));
        Polynomial b = new Polynomial(Arrays.asList(new Monomial(2, 2)));
        Monomial[] monomials = new Monomial[] {new Monomial(5, 3), new Monomial(-2, 2)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials));
        BinaryOperation sub = new SubOp();
        Polynomial actual = sub.perform(a, b);

        assertEquals(expected, actual);
    }


}