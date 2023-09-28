package com.shpp.p2p.cs.vomelianchuk.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * File: Assignment3Part4Ext.java
 * Builds a green pyramid, where bricks fall from top to bottom
 */
public class Assignment3Part4Ext extends WindowProgram {

    /* The amount of time to pause between frames (500fps). */
    private static final double PAUSE_TIME = 1000.0 / 500;

    // Constants regulate the height and width of the brick
    private static final double BRICK_HEIGHT = 30;
    private static final double BRICK_WIDTH = 60;

    // Sets the number of bricks at the base of the pyramid
    private static final int BRICKS_IN_BASE = 12;

    public void run() {
        makeAnimationPyramid();
    }

    /**
     * Builds a pyramid from bottom to top row by row
     */
    private void makeAnimationPyramid() {
        int bricksInRow = BRICKS_IN_BASE;
        for (int i = 1; i <= BRICKS_IN_BASE; i++) {
            //calculate the coordinate of the upper left corner of the brick
            double startX = (getWidth() / 2) - ((bricksInRow * BRICK_WIDTH) / 2);
            double startY = 0;

            buildRowOfBricks(startX, startY, bricksInRow--, i);
        }
    }

    /**
     * Builds a row of bricks that are next to each other
     *
     * @param x The x coordinate of the upper-left corner beginning of a row of bricks
     * @param y The y coordinate of the upper-left corner beginning of a row of bricks
     * @param bricksInRow The number of bricks in a row
     */
    private void buildRowOfBricks(double x, double y, int bricksInRow, int numberRow) {

        for (int i = 0; i < bricksInRow; i++) {
            // displacement at one time along the y coordinate
            double dy = 5;

            GRect block = buildBrick(x, y);
            add(block);

            // the brick falls until it hits the floor or another brick
            while (!blockOnTheFloorOrBlock(block, numberRow)) {
                block.move(0, dy);
                pause(PAUSE_TIME);
            }

            //displacement of the next brick along the x coordinate
            x += BRICK_WIDTH;
        }


    }

    /**
     * Checks whether the brick fell on the floor or on another brick
     *
     * @param block This is a brick that needs to be checked
     * @param numberRow Line number of the pyramid
     */
    private boolean blockOnTheFloorOrBlock(GRect block, int numberRow) {
        return block.getY() + (BRICK_HEIGHT * numberRow) >= getHeight();
    }

    /**
     * Builds a green brick with a black border
     * @param x The x coordinate of the upper-left corner of the current brick
     * @param y The y coordinate of the upper-left corner of the current brick
     */
    private GRect buildBrick(double x, double y) {
        GRect rectangle = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
        rectangle.setColor(Color.BLACK);
        rectangle.setFilled(true);
        rectangle.setFillColor(Color.GREEN);
        return rectangle;
    }
}
