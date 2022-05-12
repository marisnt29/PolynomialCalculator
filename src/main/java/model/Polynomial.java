package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial{
    private static final String PATTERN = "([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))";

    private List<Monomial> monomials = new ArrayList<>();

    public Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
        Collections.sort(this.monomials); //pt teste
    }

    public Polynomial(String s) throws Exception {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(s);


        while(m.find()) {
            monomials.add(new Monomial(m.group()));
        }



    }

    public List<Monomial> getMonomials() {
        return Collections.unmodifiableList(monomials);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(monomials, that.monomials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "monomials=" + monomials.toString() +
                '}';
    }

    public String toStringForCalc(){
        String text ="";
        int first = 0;
        for(Monomial m1 : monomials){
            if(m1.getCoefficient()!=0){
                if(first==0){
                    text+=m1.getCoefficient();
                    if(m1.getExp()>=0)
                        text+="x"+"^"+m1.getExp();
                }
                else{
                    if(m1.getCoefficient()<0){
                        text+=m1.getCoefficient();
                        if(m1.getExp()>=0)
                            text+="x"+"^"+m1.getExp();
                    }

                    if(m1.getCoefficient()>0){
                        text+="+"+m1.getCoefficient();
                        if(m1.getExp()>=0)
                            text+="x"+"^"+m1.getExp();
                    }


                }
                first = 1;
            }

            }

        if(text.equals("")){
            text+="0";
        }
        return text;
    }
}
