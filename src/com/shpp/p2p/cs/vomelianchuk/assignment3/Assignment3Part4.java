package com.shpp.p2p.cs.vomelianchuk.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * File: Assignment3Part4.java
 * Builds a green pyramid
 */
public class Assignment3Part4 extends WindowProgram {

    // Constants regulate the height and width of the brick
    private static final int BRICK_HEIGHT = 30;
    private static final int BRICK_WIDTH = 60;

    // Sets the number of bricks at the base of the pyramid
    private static final int BRICKS_IN_BASE = 12;

    public void run() {
        buildPyramid();
    }

    /**
     * Builds a pyramid from bottom to top row by row
     */
    private void buildPyramid() {
        int bricksInRow = BRICKS_IN_BASE;

        for (int i = 1; i <= BRICKS_IN_BASE; i++) {
            //calculate the coordinate of the upper left corner of the brick
            double startX = (getWidth() - (BRICK_WIDTH * bricksInRow)) / 2;
            double startY = getHeight() - (BRICK_HEIGHT * i);

            buildRowOfBricks(startX, startY, bricksInRow--);
        }
    }

    /**
     * Builds a row of bricks that are next to each other
     *
     * @param x The x coordinate of the upper-left corner beginning of a row of bricks
     * @param y The y coordinate of the upper-left corner beginning of a row of bricks
     * @param bricksInRow The number of bricks in a row
     */
    private void buildRowOfBricks(double x, double y, int bricksInRow) {
        for (int i = 0; i < bricksInRow; i++) {
            buildBrick(x, y);

            //displacement of the next brick along the x coordinate
            x += BRICK_WIDTH;
        }
    }

    /**
     * Builds a green brick with a black border
     * @param x The x coordinate of the upper-left corner of the current brick
     * @param y The y coordinate of the upper-left corner of the current brick
     */
    private void buildBrick(double x, double y) {
        GRect rectangle = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
        rectangle.setColor(Color.BLACK);
        rectangle.setFilled(true);
        rectangle.setFillColor(Color.GREEN);
        add(rectangle);
    }
}
