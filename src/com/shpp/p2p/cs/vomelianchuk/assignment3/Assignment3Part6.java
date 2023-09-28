package com.shpp.p2p.cs.vomelianchuk.assignment3;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * File: Assignment3Part6.java
 * The program makes an animation where the bridges
 * are pushed apart and the sun comes out
 */
public class Assignment3Part6 extends WindowProgram {
    // The amount of time to pause between frames (18fps)
    private static final double PAUSE_TIME = 1000.0 / 18;

    // Sun size, diameter and radius
    private static final double DIAMETER = 150;
    private static final double RADIUS = DIAMETER / 2;

    // Sets the height of the bridge
    private static final double BRIDGE_HEIGHT = 20;

    // Two new colors are set
    private static final Color LIGHT_GREEN = new Color(153, 246, 155);
    private static final Color LIGHT_BLUE = new Color(102, 171, 250);

    // Animation duration
    private static final long  DURATION = 5000;
    // Permissible deviation ±50 ms
    private static final long ALLOWED_DEVIATION =  50;

    //A variable to record the start time of the animation
    private long startTime;

    public void run() {
        //record the start time
        startTime = System.currentTimeMillis();

        // the width of the bridge is set relative to the width of the screen
        double bridgeWidth = getWidth() / 2;

        createBackground();
        createAndMoveBridge(bridgeWidth);
        createAndMoveSun();

        // Made to check duration(optional*)
        long endTime = System.currentTimeMillis();
        print(endTime - startTime);
    }

    /**
     * Creates a light blue background on the entire screen
     */
    private void createBackground() {
        GRect background = new GRect(0, 0, getWidth(), getHeight());
        background.setFilled(true);
        background.setColor(LIGHT_BLUE);
        add(background);
    }

    /**
     * Creates a bridge consisting of two halves and pushes it in different directions
     *
     * @param bridgeWidth Bridge width
     */
    private void createAndMoveBridge(double bridgeWidth) {
        GRect firstHalfBridge = createHalf(0, getHeight() - BRIDGE_HEIGHT, bridgeWidth);
        GRect secondHalfBridge = createHalf(getWidth()/2, getHeight() - BRIDGE_HEIGHT, bridgeWidth);
        add(firstHalfBridge);
        add(secondHalfBridge);

        moveBridge(firstHalfBridge, secondHalfBridge);
    }

    /**
     * Creates half of the bridge
     *
     * @param x The x coordinate of the upper left corner of the bridge half
     * @param y The y coordinate of the upper left corner of the bridge half
     * @param bridgeWidth Bridge width
     *
     * @return Half of the bridge in the form of a rectangle
     */
    private GRect createHalf(double x, double y, double bridgeWidth) {
        GRect halfBridge = new GRect(x, y, bridgeWidth, BRIDGE_HEIGHT);
        halfBridge.setFilled(true);
        halfBridge.setFillColor(LIGHT_GREEN);
        halfBridge.setColor(Color.BLACK);
        return halfBridge;
    }

    /**
     * The two halves of the bridge are pushed in different directions
     *
     * @param firstHalfBridge Rectangle, the first half of the bridge
     * @param secondHalfBridge Rectangle, the second half of the bridge
     */
    private void moveBridge(GRect firstHalfBridge, GRect secondHalfBridge) {
        // displacement along the x coordinate
        double dx = 5;
        // counts the number of moves
        int countMove = 0;

        // dx * 2:  The sum of the distance in one movement
        while (!sunWillPass(dx * 2, countMove)) {
            if (checkTime()) {
                break;
            }
            firstHalfBridge.move(-dx, 0);
            secondHalfBridge.move(dx, 0);
            countMove++;
            pause(PAUSE_TIME);
        }
    }

    /**
     * Checks if the width between the halves of the bridge is greater than the diameter of the sun
     * (+ 10 : used to keep the sun from touching the edges of the bridge)
     */
    private boolean sunWillPass(double distance, int countMove) {
        return distance * countMove >= DIAMETER + 10;
    }

    /**
     * Creates the sun and raises it up
     */
    private void createAndMoveSun() {
        GOval sun = createSun();
        add(sun);

        moveSun(sun);
    }

    /**
     * Creates a yellow sun under the bridge
     *
     * @return The sun is in the shape of a ball
     */
    private GOval createSun() {
        GOval sun = new GOval(
                getWidth() / 2 - RADIUS,
                getHeight(),
                DIAMETER, DIAMETER
        );
        sun.setFilled(true);
        sun.setColor(Color.YELLOW);
        return sun;
    }

    /**
     * Raises the sun up until it touches top edge
     * or the animation time expires
     *
     * @param sun The sun is in the shape of a ball
     */
    private void moveSun(GOval sun) {
        // displacement along the y coordinate
        double dy = -5;

        while (!hasSunRose(sun)) {
            if (checkTime()) {
                break;
            }

            sun.move(0, dy);
            pause(PAUSE_TIME);
        }
    }


    /**
     * Checks if the sun has risen by touching the top edge
     *
     * @param sun The sun is in the shape of a ball
     */
    private boolean hasSunRose(GOval sun) {
        return sun.getY() <= 0;
    }

    /**
     * Checks that the animation does not exceed the allowed duration
     *
     * @return Whether the animation reached the allowed runtime or not
     */
    private boolean checkTime() {
        long currentTime = System.currentTimeMillis();
        long passedTime = currentTime - startTime;

        long deviation = DURATION - passedTime;

        return Math.abs(deviation) <= ALLOWED_DEVIATION;
    }
}