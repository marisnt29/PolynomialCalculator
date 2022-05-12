package operations;

import model.Polynomial;

public interface BinaryOperation {
    Polynomial perform(Polynomial a, Polynomial b);
}
