public class Difference extends Function{
    protected Function function1;
    protected Function function2;

    /**
     * Constructs a new Difference function that represents the difference between two functions.
     *
     * @param function1 The first function.
     * @param function2 The second function.
     */
    public Difference(Function function1, Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }
    @Override
    public double valueAt(double x) {
        return this.function1.valueAt(x) - this.function2.valueAt(x);
    }
    @Override
    public String toString() {
        return "(" + this.function1 + " - " + this.function2 + ")";
    }

    /**
     * /**
     * Returns the derivative of the function.
     *
     * @return The derivative of the function as a new Difference object.
     * */
    @Override
    public Function derivative() {
        Difference derivative = new Difference(this.function1.derivative(), this.function2.derivative());
        return derivative;
    }
}
