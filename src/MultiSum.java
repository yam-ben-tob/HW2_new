public class MultiSum extends Function{

    public Function[] functions;

    /**
     * Represents a multi-sum of functions, composed of at least two functions.
     *
     * @param function1 the first function in the multi-sum
     * @param functions additional functions to be included in the multi-sum
     */
    public MultiSum(Function function1, Function... functions) {
        this.functions = new Function[functions.length+1];
        this.functions[0] = function1;
        for (int i = 1 ; i < functions.length+1; i++)
            this.functions[i] = functions[i-1];
    }

    /**
     * Calculates the value of the multi-sum of functions at a given value of x.
     *
     * @param x the value at which the multi-sum is evaluated
     * @return the value of the multi-sum at the given x
     */
    @Override
    public double valueAt(double x) {
        double result = 0;
        for ( int i =0; i < this.functions.length; i++)
            result += functions[i].valueAt(x);
        return result;
    }

    @Override
    public String toString() {
        String name = "(";
        for ( int i = 0 ; i < this.functions.length; i++) {
            if (i == this.functions.length-1)
                name += this.functions[i].toString() + ")";
            else name += this.functions[i].toString() + " + ";
        }
        return name;
    }

    /**
     * Returns the derivative of the multi-sum of functions, which is a MultiSum itself.
     *
     * @return the derivative of the multi-sum as a new Multisum object
     */
    @Override
    public Function derivative() {

        Function[] derivatives = new Function[this.functions.length-1];
        Function derivative1 = this.functions[0].derivative();
        for (int i= 1; i < this.functions.length; i++) {
            derivatives[i-1] = this.functions[i].derivative();
        }
        MultiSum derivatives_sum = new MultiSum(derivative1, derivatives);
        return derivatives_sum;
    }
}
