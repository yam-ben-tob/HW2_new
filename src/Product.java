public class Product extends MultiProduct{

    public Product(Function function1, Function function2) {
          super(function1, function2);
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
     * Calculates the derivative of the function.
     *
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        return super.derivative();
    }
}

