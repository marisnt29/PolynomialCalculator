package operations;

import model.Monomial;
import model.Polynomial;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DivOpTest {

    @Test
    public void perform() {

        Monomial[] monomialsA = new Monomial[]  { new Monomial(1, 3), new Monomial(1, 2)};
        Polynomial a = new Polynomial(Arrays.asList(monomialsA));

        Monomial[] monomialsB = new Monomial[]  { new Monomial(1, 1)};
        Polynomial b = new Polynomial(Arrays.asList(monomialsB));

        Monomial[] monomials = new Monomial[] { new Monomial(1, 2), new Monomial(1, 1) };
        Polynomial expected = new Polynomial(Arrays.asList(monomials));


        BinaryOperation div = new DivOp();
        Polynomial actual = div.perform(a, b);

        System.out.println(expected.toString());
        System.out.println(actual.toString());

        assertEquals(expected, actual);
    }
}