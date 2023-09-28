package com.shpp.p2p.cs.vomelianchuk.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;

/**
 * File: Assignment3Part2.java
 * Receives a number as an input and converts it
 * to a unit through a certain number of operations
 */
public class Assignment3Part2 extends TextProgram {
    // The number that will be converted is in the range from 1
    int number;

    public void run() {
        enterNumber();
        convertingNumberToOne();
    }

    /**
     * The user enters a positive integer,
     * when the managed data does not satisfy the condition,
     * the user is notified and the program is stopped
     */
    private void enterNumber() {
        print("Enter a number: ");
        try {
            number = readInt();
            if (number <= 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("Incorrect data!" +
                    "\nTry again from the beginning!");
            System.exit(0);
        }
    }

    /**
     * The number entered by the user is converted to 1 under the condition:
     * if even - (n / 2),
     * when unwashed - (3 * n + 1)
     */
    private void convertingNumberToOne() {
        boolean isOne = false;
        while (!isOne) {
            if (number == 1) {
                println("The end!");
                isOne = true;
            } else if (number % 2 != 0) {
                println(number + " is odd so I make 3n + 1: " + (number = 3 * number + 1));
            } else {
                println(number + " is even so I take half: " + (number /= 2));
            }
        }
    }
}
