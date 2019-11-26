public class Fraction implements Comparable {
    int numerator;
    int denominator;
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }
    public Fraction(int numerator, int denominator){
        if(denominator != 0 && denominator <= Integer.MAX_VALUE && denominator >= Integer.MIN_VALUE){
            this.denominator = denominator;
            this.numerator = numerator;
        }
        else{
            System.out.println("invalid input");
            this.denominator = 1;
            this.numerator = 0;
        }
        if(this.numerator <= -1 && this.denominator <= -1){
            this.numerator = Math.abs(this.numerator);
            this.denominator = Math.abs(this.denominator);
        }

    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    double getRealValue(){
        double result = numerator/denominator;
        return result;
    }
    Fraction reduce(Fraction f){
        int remainder = 0;
        int num1 = f.numerator;
        int num2 = f.denominator;
        while(num2 != 0){
            remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        Fraction result = new Fraction(f.numerator/num1, f.denominator/num1);
        return result;
    }
    Fraction add(Fraction f){
        double resultantFraction = this.getRealValue() + f.getRealValue();
        String s = String.valueOf(resultantFraction);
        int digitsDec = s.length() - 1 - s.indexOf('.');

        int newDenominator = 1;
        for(int i = 0; i < digitsDec; i++){
            resultantFraction *= 10;
            newDenominator *= 10;
        }
        int num = (int) Math.round(resultantFraction);
        Fraction preResult = new Fraction(num, newDenominator);
        Fraction result = preResult.reduce(this);
        return result;
    }
    @Override
    public boolean equals(Object f) {
        this.reduce(this);
        this.reduce((Fraction) f);
        return this.denominator == ((Fraction) f).denominator && this.numerator == ((Fraction) f).numerator;
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o)){
            return 0;
        }
        Fraction reducedThis = this.reduce(this);
        Fraction reducedParam = this.reduce((Fraction) o);
        if(reducedThis.getRealValue() < reducedParam.getRealValue()){
            return -1;
        }
        if(reducedThis.getRealValue() > reducedParam.getRealValue()){
            return 1;
        }
        return 0;
    }
}
