public class Quotient extends Function{
    private Function numerator;
    private Function denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
          return  numerator.valueAt(x) / denominator.valueAt(x);
    }

    @Override
    public String toString() {
          return "(" + this.numerator + " / " + this.denominator + ")";
    }

    /**
     * Returns the derivative of the function as a new Quotient object.
     * using the formula: (f/g)' = (f'*g-g'*f)/g^2
     *
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        Product numeratorPart1 = new Product(this.numerator.derivative(), this.denominator);
        Product numeratorPart2 = new Product(this.denominator.derivative() ,this.numerator);
        Difference numerator = new Difference(numeratorPart1, numeratorPart2);
        Quotient derivative = new Quotient(numerator, new Power(this.denominator,2));
        return derivative;
    }
}