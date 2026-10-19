package com.shpp.p2p.cs.khavryliuk.assignment1;

import com.shpp.karel.KarelTheRobot;

public class SuperKarel extends KarelTheRobot {

    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /**
     * Precondition: Karel is standing on the last cell.
     * Result: Karel checked whether a beeper needs to be placed on the last cell.
     */


    public void checkTheLastBeeper() throws Exception {
        if (noBeepersPresent()) {
            turnAround();
            move();
            if (noBeepersPresent()) {
                turnAround();
                move();
                putBeeper();
            } else {
                turnAround();
                move();
            }
        }
    }
}