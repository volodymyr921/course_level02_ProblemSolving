package com.shpp.p2p.cs.vomelianchuk.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Random;

/**
 * File: Assignment3Part5.java
 * This is a hypothetical casino game with a simple ideology.
 * Two people play: the lucky one and the sweaty one.
 * The lucky person leaves the casino when he earns $20 or more.
 */
public class Assignment3Part5 extends TextProgram {
    public void run() {
        // total earnings
        int totalEarn = 0;
        // number of games
        int countOfGames = 0;

        while (totalEarn < 20) {
            int earnPerGame = playGame();
            println("This game, you earned $" + earnPerGame);
            totalEarn += earnPerGame;
            println("Your total is $" + totalEarn);
            countOfGames++;
        }

        println("It took " + countOfGames + " games to earn $20");
    }

    /**
     * One game is played, depending on the fall of the coin,
     * a certain amount of money is received for one game
     *
     * @return Earnings per game
     */
    private int playGame() {
        int earnings = 1;
        while (true) {

            // if 1, then heads, and if 0, then tails
            int headsOrTails =  new Random().nextInt(2);
            if (headsOrTails == 1) {

                // puts the same amount as on the table
                earnings += earnings;
            } else {
                return earnings;
            }
        }
    }
}
