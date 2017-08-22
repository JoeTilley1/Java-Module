/**
 * Created by Joe on 28/09/2016.
 */
/*
 * PROJECT II: Polynomial.java
 *
 * This file contains a template for the class Polynomial. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file.
 *
 * This class is designed to use Complex in order to represent polynomials
 * with complex co-efficients. It provides very basic functionality and there
 * are very few methods to implement! The project formulation contains a
 * complete description.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file! You should also test this class using the main()
 * function.
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 */

class Polynomial {
    /**
     * An array storing the complex co-efficients of the polynomial.
     */
    Complex[] coeff;

    // ========================================================
    // Constructor functions.
    // ========================================================

    /**
     * General constructor: assigns this polynomial a given set of
     * co-efficients.
     *
     * @param coeff  The co-efficients to use for this polynomial.
     */
    public Polynomial(Complex[] coeff) {
        // You need to fill in this function.
        int n = coeff.length -1 ;
        while(coeff[n] == new Complex()) {
            n = n - 1;
        }
        this.coeff = new Complex[n+1];
        for(int x=0; x <= n; x++) {
            this.coeff[x] = coeff[x];
        }
    }

    /**
     * Default constructor: sets the Polynomial to the zero polynomial.
     */
    public Polynomial() {
        // You need to fill in this function.
        coeff = new Complex[1];
        coeff[0] = new Complex();
    }

    // ========================================================
    // Operations and functions with polynomials.
    // ========================================================

    /**
     * Create a string representation of the polynomial.
     *
     * For example: (1.0+1.0i)+(1.0+2.0i)X+(1.0+3.0i)X^2
     */
    public String toString() {
        // You need to fill in this function.
        String str = coeff[0].toString();
        if( degree() >= 1)
            str = str + "+(" + coeff[1].toString()  + ")X";
        if (degree() > 1)
            for(int x=2; x <= degree() ; x++){
                str = str + "+(" + coeff[x].toString()  + ")X^" + x;
        }
        return str;
    }

    /**
     * Returns the degree of this polynomial.
     */
    public int degree() {
        // You need to fill in this function.
        return coeff.length -1 ;
    }

    /**
     * Evaluates the polynomial at a given point z.
     *
     * @param z  The point at which to evaluate the polynomial
     * @return   The complex number P(z).
     */
    public Complex evaluate(Complex z) {
        // You need to fill in this function.
        int n = degree();
        Complex answer = coeff[n];
        while(n != 0){
            answer = coeff[n-1].add(answer.multiply(z));
            n = n-1;
        }
        return answer;
    }

    /**
     * Calculate and returns the derivative of this polynomial.
     *
     * @return The derivative of this polynomial.
     */
    public Polynomial derivative() {
        // You need to fill in this function.
        Complex[] deriv = new Complex[degree()];
        for(int x=0; x <= degree()-1 ; x++) {
            deriv[x] = coeff[x+1].multiply(new Complex(x+1)) ;
        }
        return new Polynomial(deriv);
    }

    // ========================================================
    // Tester function.
    // ========================================================

    public static void main(String[] args) {
        // You need to fill in this function.
        Complex[] Coeffs;
        Complex numb = new Complex(3);
        Coeffs = new Complex[3];
        Coeffs[0] = new Complex(1.0, 1.0);
        Coeffs[1] = new Complex(1.0, 1.0);
        Coeffs[2] = new Complex(1.0, 1.0);
        Polynomial Joey = new Polynomial(Coeffs);
        System.out.println(Joey.evaluate(numb));
        Polynomial Beckie = Joey.derivative();
        System.out.println(Beckie.toString());
    }
}