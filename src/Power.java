public class Power extends Function {

    private Function function;
    private int n;
    public Power(Function function, int n) {
        this.function = function;
        this.n = n;
    }

    @Override
    public double valueAt(double x) {
        return Math.pow(function.valueAt(x),n);
    }

    @Override
    public String toString() {
        return String.format("(%s^%d)", this.function,n);
    }

    /**
     * Returns the derivative of the function as a new Multi-product object.
     * using the formula: (f^k)' = (k-1)*f^(k-1)*f'
     *
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        if (this.n == 1)
            return this.function.derivative();

        Constant constant = new Constant(this.n);
        Power power = new Power(function, this.n-1);

        return new MultiProduct(constant,power,this.function.derivative());
    }
}