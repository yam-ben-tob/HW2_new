public class Constant extends Polynomial {

    public Constant(double constant) {
        super(constant);
    }
    @Override
    public double valueAt(double x) {
        return super.valueAt(x);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Returns the derivative of the function.
     *
     * @return the derivative of the function as a new Function object
     * @see Function#derivative()
     */
    @Override
    public Function derivative() {
        return super.derivative();
    }
}
