public class MultiProduct extends Function {

    private Function[] functions;

    /**
     * Constructs a MultiProduct object composed of at least two functions.
     *
     * @param function1  the first function in the product
     * @param functions  additional functions to be multiplied
     */
    public MultiProduct(Function function1 , Function... functions) {
      this.functions = new Function[functions.length+1];
      this.functions[0] = function1;
      for (int i =1 ; i < functions.length+1; i++)
          this.functions[i] = functions[i-1];
    }

    /**
     * Calculates the value of the multi-product of functions at a given value of x.
     *
     * @param x the value at which the multi-product is evaluated
     * @return the value of the multi-product at the given x
     */
    @Override
    public double valueAt(double x) {
        double result = 1;
        for (int i =0; i < this.functions.length; i++)
            result *= functions[i].valueAt(x);
        return result;
    }

    @Override
    public String toString() {
        String name = "(";
        for (int i = 0; i < this.functions.length; i++) {
            if (i == this.functions.length - 1)
                name += this.functions[i].toString() + ")";
            else name += this.functions[i].toString() + " * ";
        }
        return name;
    }

    /**
     * Creates a derivative addend.
     * Takes the derivative of the  i index factor
     * and multiplying it with all the other functions in the Multi-product.
     *
     * @param i the index of the function to derive
     * @return a new MultiProduct object representing a derivative addend
     */
    private MultiProduct createDerivativeAddend(int i) {
      Function[] functions = new Function[this.functions.length-1];
      Function function1 = this.functions[i].derivative();
      for (int j=0; j<this.functions.length-1; j++) {
          if (j<i)
            functions[j] = this.functions[j];
          else if (j >= i)
              functions[j] = this.functions[j+1];
      }
      MultiProduct addend_i = new MultiProduct(function1, functions);
      return addend_i;
    }

    /**
     * Calculates the derivative of the Multi-product function using the product rule.
     * For example: (uvw)' = u'vw + v'uw + w'uv.
     *
     * @return the derivative of the multi-product as a new Multisum object
     */
    @Override
    public Function derivative() {

      MultiProduct[] addends = new MultiProduct[this.functions.length-1];
      MultiProduct addend1 = createDerivativeAddend(0) ;

      for (int i=0; i<this.functions.length-1; i++)
          addends[i] = createDerivativeAddend(i+1);
      MultiSum derivative = new MultiSum(addend1, addends);
      return derivative;

    }
}

