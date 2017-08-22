/**
 * Created by Joe on 03/07/2016.
 */
public class Fraction {
    // ============================================================
    // Instance variables
    // ============================================================

    /**
     * The numerator of the fraction.
     */
    private int numerator;
    /**
     * The denominator of the fraction.
     */
    private int denominator;

    // ============================================================
    // Constructors
    // ============================================================

    /**
     * Constructor which takes coefficients explicitly.
     *
     * Behaviour: Constructs a fraction with the specified numerator and
     *            denominator. Remember that your fraction should *always* be
     *            stored in irreducible form.
     *
     * @param num   The numerator
     * @param denom The denominator
     */



    public Fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
        reduce();
    }

    //Finds the greatest common divisor of the numerator and denominator
    private int gcd() {
        int d = 1;
        for (int n=1; (n < numerator) || (n < denominator) ; n++){
            if ( ((numerator % n) == 0) &&  ((denominator % n) == 0)){
                d = n;
            }
        }
        return d;
    }

    //Reduces a fraction to its lowest terms
    private void reduce() {
        this.numerator  = numerator/gcd() ;
        this.denominator = denominator/gcd() ;
    }

    /**
     * Constructor which takes coefficients explicitly.
     *
     * Behaviour: Constructs a fraction which represents an integer: set the
     *            specified numerator and set denominator to 1.
     *
     * @param num The numerator
     */
    public Fraction(int num) {
        // This method is complete.
        this(num, 1);
    }

    /**
     * Default constructor.
     *
     * Behaviour: Constructs a fraction and set the default value to 0;
     *            i.e. numerator = 0 and denominator = 1
     */
    public Fraction() {
        // This method is complete.
        this(0, 1);
    }


    // ==============================================================
    // Convertors
    //
    // These functions will convert the Fraction to other data types.
    // ==============================================================

    /**
     * Convert the fraction to the floating point representation using double
     * precision.
     *
     * Behaviour: Converts this fraction into a double.
     *
     * @return    A double value obtained by dividing the fraction's numerator
     *            by its denominator.
     */
    public double toDouble() {
        // Fill in this method.
        return (double) (numerator/denominator);
    }


    /**
     * Convert the fraction to the floating point representation using the
     * single precision.
     *
     * Behaviour: Converts this fraction into a float value.
     *
     * @return    A float value obtained by dividing the fraction's numerator by
     *            its denominator
     */
    public float toFloat() {
        // This method is complete.
        return (float) numerator / denominator;
    }

    /**
     * Convert the fraction to a string.
     *
     * Behaviour: Converts this fraction into a string
     *
     * @return    A string of the form "num/denom". If the denominator is 1,
     *            returns a string containing only the numerator.
     */
    public String toString() {
        // Fill in this method.
        if ( denominator == 1 ) {
            return (String) Integer.toString(numerator);
        } else {
            return (String) Integer.toString(numerator) + "/" + Integer.toString(denominator);
        }
    }


    // ============================================================
    // Accessors and mutator methods (getters and setters)
    // ============================================================

    /**
     * Get denominator.
     *
     * Behaviour: Returns the denominator of this fraction.
     *
     * @return    The denominator of this fraction.
     */
    public int getDenominator() {
        // This method is complete.
        return denominator;
    }

    /**
     * Get numerator.
     *
     * Behaviour: Returns the numerator of this fraction.
     *
     * @return    The numerator of this fraction.
     */
    public int getNumerator() {
        // This method is complete.
        return numerator;
    }

    //============================================================
    // Operations with fractions - Core methods
    //============================================================

    /**
     * Addition operation.
     *
     * Behaviour: Adds this fraction to a supplied fraction.
     *
     * @param f  The fraction to be added.
     * @return   The sum of this fraction and f.
     */
    public Fraction add(Fraction f) {
        // Fill in this method.
        int num   = numerator * f.denominator + f.numerator * denominator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }

    /**
     * Subtraction operation.
     *
     * Behaviour: Subtracts a fraction from this fraction.
     *
     * @param f   The fraction to be subtracted.
     * @return    The difference between this fraction and f.
     *
     */
    public Fraction subtract(Fraction f) {
        // This method is complete.
        int num   = numerator * f.denominator - f.numerator * denominator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }

    /**
     * Division.
     *
     * Behaviour: Divides this fraction by another fraction.
     *
     * @param f   The fraction to be used as a divisor.
     * @return    The quotient of this fraction and f.
     */
    public Fraction divide(Fraction f) {
        // Fill in this method.
        int num   = numerator * f.denominator ;
        int denom = denominator * f.numerator;

        return new Fraction(num, denom);
    }

    /**
     * Multiplication.
     *
     * Behaviour: Multiplies this fraction and another fraction.
     *
     * @param f   The fraction to be multiplied.
     * @return    The product of this fraction and f.
     */
    public Fraction multiply(Fraction f) {
        // Fill in this method.
        int num   = numerator * f.numerator ;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }

    // ======================================================================
    // END OF USER MODIFIABLE CODE
    //
    // DO NOT CHANGE ANY FUNCTIONS IN THE SECTION BELOW; THEY ARE NEEDED FOR
    // THE AUTOMATED MARKING SYSTEM. YOUR CODE CANNOT BE MARKED WITHOUT IT!
    // ======================================================================

    /**
     * Compare two fractions.
     *
     * @param  q  The fraction to compare with.
     * @return    true if q is Fraction equal to this fraction .
     */
    public boolean equals(Fraction q) {
        return (numerator   == q.getNumerator() &&
                denominator == q.getDenominator());
    }

    //TESTING THE SHIT OUT YEAH BOI
    public static void main(String[] args) {

        Fraction Joey = new Fraction(10,20);
        Fraction Becky = new Fraction(10,40);
        System.out.println(Joey.add(Becky));
    }
}
