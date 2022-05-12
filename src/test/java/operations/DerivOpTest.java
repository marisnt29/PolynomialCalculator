package operations;

import model.Monomial;
import model.Polynomial;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DerivOpTest {


    @Test
    public void perform(){
        Monomial[] monomials = new Monomial[] {new Monomial(3, 5), new Monomial(12, 2)};
        Polynomial a = new Polynomial(Arrays.asList(monomials));
        Monomial[] monomialse = new Monomial[] {new Monomial(15, 4),new Monomial(24,1)};
        Polynomial expected = new Polynomial(Arrays.asList(monomialse));
        UnaryOperation der = new DerivOp();
        Polynomial actual = der.perform(a);

        assertEquals(expected, actual);
    }


}