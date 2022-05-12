package operations;

import model.Monomial;
import model.Polynomial;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IntegrateOpTest {

    @Test
    public void perform() {
        Monomial[] monomials = new Monomial[] {new Monomial(3, 5), new Monomial(12, 2)};
        Polynomial a = new Polynomial(Arrays.asList(monomials));
        Monomial[] monomialse = new Monomial[] {new Monomial(3/6f,6 ),new Monomial(12/3f,3)};
        Polynomial expected = new Polynomial(Arrays.asList(monomialse));
        UnaryOperation integ = new IntegrateOp();
        Polynomial actual = integ.perform(a);

        assertEquals(expected, actual);

    }
}