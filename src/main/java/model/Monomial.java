package model;

import java.util.Objects;

public class Monomial implements Comparable{
    private float coefficient;
    private int exp;

    public Monomial(float coefficient, int exp) {
        this.coefficient = coefficient;
        this.exp = exp;
    }

    public Monomial(String s) {
        String[] parts = s.split("x\\^");
        this.coefficient = Float.parseFloat(parts[0]);
        this.exp = Integer.parseInt(parts[1]);
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return Float.compare(monomial.coefficient, coefficient) == 0 && exp == monomial.exp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, exp);
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "coefficient=" + coefficient +
                ", exp=" + exp +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int exp = ((Monomial)o).getExp();
        return exp - this.exp;
    }
}
