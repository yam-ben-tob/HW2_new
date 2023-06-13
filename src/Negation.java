public class Negation extends Function{
    private Function function;


    public Negation (Function function) {
        this.function = function;
    }

    /**
     * Returns the value of the function at the specified x value, using (-) on the original function.
     *
     * @param x the x value at which to evaluate the function
     * @return the negated value of the function at the specified x value
     */
    @Override
    public double valueAt(double x) {
        return -this.function.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-" + this.function + ")";
    }

    /**
     * Creates a derivative function using the derivative of the original function
     *
     * @return the derivative function as a Negation object
     */
    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }
}
