import java.lang.Math;
abstract class Function {
    private static final double DEFAULT_EPSILON = 1e-5;
    private static final double TAYLOR_CENTER_POINT = 0;

    /**
     * Calculates the value of the function at the given value of x.
     *
     * @param x the input value at which to evaluate the function
     * @return the value of the function at the specified input value x
     */
    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    /**
     * Returns the derivative of the function.
     *
     * @return The derivative of the function as a new Function
     */
    public abstract Function derivative();

    /**
     * Implements the bisection method to find the root of a function within a given interval.
     *
     * @param a       the left endpoint of the interval
     * @param b       the right endpoint of the interval
     * @param epsilon the desired accuracy (the acceptable error tolerance)
     * @return the approximate root of the function within the specified interval
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;

        while (right-left > epsilon) {
            double mid = (left+right)/2;
            if (this.valueAt(a) * this.valueAt(mid) > 0 )
                left = mid;
            else right = mid;
        }
        return (left+right)/2;
    }

    /**
     * Implements the bisection method to find the root of a function within a given interval,
     * using a default epsilon value.
     *
     * @param a the left endpoint of the interval
     * @param b the right endpoint of the interval
     * @return the approximate root of the function within the specified interval
     */
    public double bisectionMethod(double a, double b) {
        return this.bisectionMethod(a, b, DEFAULT_EPSILON);
    }
    /**
     * Implements the Newton-Raphson method to find the root of a function around a given point.
     *
     * @param a       the point which the root is searched around (in its neighborhood)
     * @param epsilon the desired accuracy (the acceptable error tolerance)
     * @return the approximate root of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        while (Math.abs(this.valueAt(x)) >= epsilon) {
            Quotient quotient = new Quotient(this, this.derivative());
            x -= quotient.valueAt(x);
        }
        return x;
    }
    /**
     * Implements the Newton-Raphson method to find the root of a function around a given point,
     * using a default epsilon value.
     *
     * @param a the point which the root is searched around (in its neighborhood)
     * @return the approximate root of the function
     */
    public double newtonRaphsonMethod(double a) {
        return this.newtonRaphsonMethod(a,DEFAULT_EPSILON);
    }

    /**
     * Generates the Taylor polynomial of degree n for the function.
     *
     * @param n the degree of the Taylor polynomial
     * @return the Taylor polynomial of the function
     */
    public Function taylorPolynomial(int n){
        double[] coefficients = new double[n+1];
        Function derivative_i = this;

        for (int i=0; i <= n ; i++) {
            coefficients[i] = derivative_i.valueAt(TAYLOR_CENTER_POINT)/factorial(i);
            derivative_i = derivative_i.derivative();
        }
        Polynomial taylorPolynomial = new Polynomial(coefficients);
        return  taylorPolynomial;
    }
    /**
     * Computes the factorial of a given integer.
     *
     * @param n the integer for which the factorial is computed
     * @return the factorial of the given integer
     */
    private static double factorial(int n) {
            double factorial = 1;
            for (int i=2; i <= n; i++)
                factorial *= i;
            return factorial;
    }
}

