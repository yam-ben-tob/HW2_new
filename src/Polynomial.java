public class Polynomial extends Function {
    protected double[] coefficients;

    public Polynomial(double... coefficient) {
        this.coefficients = coefficient;
    }

    /**
     * Calculates the value of a polynomial at a given value of x.
     *
     * @param x the value of x at which to evaluate the polynomial
     * @return the value of the polynomial at the given x
     */
    @Override
    public double valueAt(double x) {
        double result = 0;
        for (int i = 0 ; i < coefficients.length; i++) {
            result += this.coefficients[i] * Math.pow(x,i);
        }
        return result;
    }

    /**
     * Returns a string representation of the polynomial.
     *
     * @return a string representation of the polynomial
     */
    @Override
    public String toString() {
        String name = "(";
        if (this.coefficients.length == 1 && this.coefficients[0] == 0)
            name += (int) this.coefficients[0];
        if (this.coefficients[0] != 0){
            if (this.coefficients[0] % 1 == 0)
                name += (int) this.coefficients[0];
            else
                name += this.coefficients[0];
        }
        String power = "x";
        for (int i = 1; i < this.coefficients.length; i++) {
            if (i > 1)
                power = "x^" + i;
            if (this.coefficients[i] != 0) {
                if (this.coefficients[i] < 0 && this.coefficients[i] != -1){
                    if (this.coefficients[i] % 1 == 0)
                        name += " - " + (int)coefficients[i]*(-1) + power;
                    else
                        name += " - " + coefficients[i]*(-1) + power;
                }
                else if (this.coefficients[i] == -1)
                    name += " - " + power;
                else if (this.coefficients[i] == 1) {
                    if (name.equals("("))
                        name += power;
                    else
                        name += " + " + power;
                }
                else{
                    if (i == 1 && this.coefficients[0] == 0){
                        if (this.coefficients[i] % 1 == 0)
                            name += (int)coefficients[i] + power;
                        else
                            name += coefficients[i] + power;
                    }
                    else{
                        if (this.coefficients[i] % 1 == 0)
                            name += " + " + (int)coefficients[i] + power;
                        else
                            name += " + " + coefficients[i] + power;
                    }
                }
            }
        }
        if(name.equals("(")) name+= 0;
        name += ")";
        return name;
    }

    /**
     * Returns the derivative of the polynomial as a new Polynomial object.
     *
     * @return the derivative of the polynomial
     */
    @Override
    public Function derivative() {
        if (this.coefficients.length == 1)
            return new Constant(0); // returning Constant instead of Polynomial

        double[] derivatives = new double[this.coefficients.length-1];
        for (int i = 0; i < this.coefficients.length-1; i++) {
            derivatives[i] = this.coefficients[i+1] * (i+1);
        }
        return new Polynomial(derivatives);
    }
}

