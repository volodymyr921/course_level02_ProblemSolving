package com.shpp.p2p.cs.vomelianchuk.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * File: Assignment3Part3.java
 * Raise the number to the power and output the result
 */
public class Assignment3Part3 extends TextProgram {

    public void run() {
        // The number that we will raise is in the range of real numbers
        double base = 2.0;
        // The number to which we will raise lies in the interval of whole numbers
        int exponent = 3;

        println(
                base + " to the power of " + exponent + " is " +
                raiseToPower(base, exponent)
        );
    }

    /**
     * The method calculates a number raised to a power and returns the result
     *
     * @param base A number that is raised to a power
     * @param exponent A number that is the power to which it is raised
     *
     * @return The number is raised to a power
     */
    private double raiseToPower(double base, int exponent) {
        double result = 1;

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        }

        // with a negative exponent, the base is inverted
        if (exponent < 0) {
            base = 1 / base;
            for (int i = 0; i > exponent; i--) {
                result *= base;
            }
        }

        return result;
    }
}
