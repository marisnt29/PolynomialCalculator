package operations;

import operations.AddOp;
import operations.BinaryOperation;
import org.junit.Test;
import model.Monomial;
import model.Polynomial;



import java.util.Arrays;

import static org.junit.Assert.*;

public class AddOpTest {
    @Test
    public void perform() {
        Polynomial a = new Polynomial(Arrays.asList(new Monomial(1, 1)));
        Polynomial b = new Polynomial(Arrays.asList(new Monomial(2, 2)));
        Monomial[] monomials = new Monomial[] {new Monomial(2, 2), new Monomial(1, 1)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials));
        BinaryOperation add = new AddOp();
        Polynomial actual = add.perform(a, b);

        assertEquals(expected, actual);
    }


    @Test
    public void add2() throws Exception {
        Polynomial a = new Polynomial("1x^2");
        Polynomial b = new Polynomial("2x^2");
        Polynomial expected = new Polynomial("3x^2");

        BinaryOperation add = new AddOp();
        Polynomial actual = add.perform(a, b);

        assertEquals(expected, actual);
    }
}
