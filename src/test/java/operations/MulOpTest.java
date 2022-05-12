package operations;

import model.Monomial;
import model.Polynomial;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MulOpTest {

    @Test
    public void perform() {
        Monomial[] monA = new Monomial[]  { new Monomial(2, 3), new Monomial(5, 2)};
        Polynomial a = new Polynomial(Arrays.asList(monA));
        Monomial[] monB = new Monomial[]  { new Monomial(1, 2), new Monomial(1, 0)};
        Polynomial b = new Polynomial(Arrays.asList(monB));
        Monomial[] monomials = new Monomial[] {new Monomial(2, 5), new Monomial(5, 4),new Monomial(2, 3),new Monomial(5, 2)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials));
        BinaryOperation mul = new MulOp();
        Polynomial actual = mul.perform(a, b);

        assertEquals(expected, actual);
    }
}