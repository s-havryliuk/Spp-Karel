package com.shpp.p2p.cs.khavryliuk.assignment1;

public class Assignment1Part03 extends SuperKarel {
    public void run() throws Exception {
        if (frontIsBlocked()) {
            turnLeft();
            if (frontIsBlocked()) {
                putBeeper();
            } else {
                createARowOfBeepers();
            }
        }

        while (frontIsClear()) {
            createARowOfBeepers();
            moveToTheWesternRow();
            if (frontIsBlocked()) {
                turnLeft();
            } else {
                checkTheLowerBeeper();
            }
            createARowOfBeepers();
            moveToTheEasternRow();
        }
    }

    /**
     * Precondition: none
     * Result: Karel created a row of beepers by placing them every other step.
     */
    private void createARowOfBeepers() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
            if (frontIsClear()) {
                move();
            }
        }
        if (frontIsBlocked()) {
            checkTheLastBeeper();
        }

    }


    /**
     * Precondition: Karel is facing east.
     * Result: Karel moves on to the next line and looks toward the west.
     */

    private void moveToTheWesternRow() throws Exception {
        turnLeft();
        if (frontIsBlocked()) {
            turnRight();
        } else {
            move();
            turnLeft();
        }

    }

    /**
     * Precondition: Karel is facing west, and there is a cell below him.
     * Result: Karel checks whether there is a beeper below; if so, it takes a step forward.
     */

    private void checkTheLowerBeeper() throws Exception {
        turnLeft();
        move();
        if (beepersPresent()) {
            turnAround();
            move();
            turnLeft();
            move();
        } else {
            turnAround();
            move();
            turnLeft();
        }
    }

    /**
     * Precondition: Karel is facing west.
     * Result: Karel moves to the next line and looks toward the east.
     */

    private void moveToTheEasternRow() throws Exception {
        turnRight();
        if (frontIsBlocked()) {
            turnLeft();
        } else {
            move();
            turnRight();
        }

    }
}