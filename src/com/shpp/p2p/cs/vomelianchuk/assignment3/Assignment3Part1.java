package com.shpp.p2p.cs.vomelianchuk.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;

/**
 * File: Assignment3Part1.java
 * Calculates and displays the result of whether
 * a sufficient number of days have been performed
 * exercises for cardiovascular health and blood pressure
 */
public class Assignment3Part1 extends TextProgram {

    // Describes the minimum number of days for exercise for cardiovascular health
    private static final int MIN_DAY_EXERCISE_CARDIOVASCULAR = 5;
    // Describes the minimum duration of exercise for cardiovascular health
    private static final int MIN_MINUTES_EXERCISE_CARDIOVASCULAR = 30;

    // Describes the minimum number of days for exercise for blood pressure
    private static final int MIN_DAY_EXERCISE_PRESSURE = 3;
    // Describes the minimum duration of exercise for blood pressure
    private static final int MIN_MINUTES_EXERCISE_PRESSURE = 40;

    // An array describing the number of minutes of exercise every day during the week
    int[] minutes = new int[7];
    // A counter of the days of performance of the norm of exercises for cardiovascular health
    int countDayCardiovascular = 0;
    // A counter of the days of performance of the norm of exercises for blood pressure
    int countDayPressure = 0;

    public void run() {
        enterData();
        countingDaysWithNormOfExercise();
        printResultOfCardiovascularHealth();
        printResultOfBloodPressure();
    }

    /**
     * A method in which the user enters exercise data for seven days,
     * if the data is not within a range of positive integers [0;1440] (1440 - maximum minutes per day),
     * the program will stop and have to start over
     */
    private void enterData() {
        for (int i = 0; i < 7; i++) {
            print("How many minutes did you do on day " + (i + 1) + "? ");

            // data compliance check
            try {
                minutes[i] = readInt();

                // Checking whether a number is between 0 and 1440
                if ((minutes[i] < 0) || (minutes[i] > 1440)) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Incorrect data!" +
                        "\nTry again from the beginning!");
                System.exit(0);
            }
        }
    }

    /**
     * Counts the number of days in which the condition
     * for cardiovascular health and blood pressure is met
     */
    private void countingDaysWithNormOfExercise() {
        for (int minutesDay : minutes) {
            if (minutesDay >= MIN_MINUTES_EXERCISE_CARDIOVASCULAR) {
                countDayCardiovascular++;
            }
            if (minutesDay >= MIN_MINUTES_EXERCISE_PRESSURE) {
                countDayPressure++;
            }
        }
    }

    /**
     * Prints a conclusion about the number of exercises for cardiovascular health
     */
    private void printResultOfCardiovascularHealth() {
        println("\nCardiovascular health:");
        if (countDayCardiovascular >= MIN_DAY_EXERCISE_CARDIOVASCULAR) {
            println("\tGreat job! You've done enough exercise for cardiovascular health.");
        } else {
            println(
                    "\tYou needed to train hard for at least " +
                            (MIN_DAY_EXERCISE_CARDIOVASCULAR - countDayCardiovascular) +
                            " more day(s) a week!"
            );
        }
    }

    /**
     * Prints a conclusion about the number of exercises for blood pressure
     */
    private void printResultOfBloodPressure() {
        println("Blood pressure:");
        if (countDayPressure >= MIN_DAY_EXERCISE_PRESSURE) {
            println("\tGreat job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println(
                    "\tYou needed to train hard for at least " +
                            (MIN_DAY_EXERCISE_PRESSURE - countDayPressure) +
                            " more day(s) a week!"
            );
        }
    }
}
