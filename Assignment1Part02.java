package com.shpp.p2p.cs.khavryliuk.assignment1;

public class Assignment1Part02 extends SuperKarel {
    public void run() throws Exception {
        moveAndPlaceTheBeeperEveryOtherStep();
        returnToStart();
        placeAllBeepersAtStart();
        distributeBeepersAcrossCells();
        removesExcessBeepers();
    }


    /**
     * Precondition: none
     * Karel moves and places a beeper every other cell, then turns around and faces west.
     */
    private void moveAndPlaceTheBeeperEveryOtherStep() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
            if (frontIsClear()) {
                move();
            }
        }
        if (frontIsBlocked()) {
            checkTheLastBeeper();
            turnAround();
        }
    }

    /**
     * Result: Karel moves forward until he encounters a wall in front of him,
     * then turns around to face the opposite direction.
     */

    private void returnToStart() throws Exception {
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }

    /**
     * Result: Karel has moved all the beepers to the starting point and is facing east.
     */
    private void placeAllBeepersAtStart() throws Exception {
        move();
        while (frontIsClear()) {
            if (beepersPresent()) {
                moveBeeperToStart();
                move();
            } else {
                move();
            }
        }
        if (frontIsBlocked() && beepersPresent()) {
            moveBeeperToStart();
        } else {
            turnAround();
            returnToStart();
        }
    }

    /**
     * Precondition: There is a beeper on the cell where Karel is standing.
     * Result: Karel picks up the beeper and puts it at the start.
     */

    private void moveBeeperToStart() throws Exception {
        pickBeeper();
        turnAround();
        returnToStart();
        putBeeper();
    }


    /**
     * Precondition: Carol is standing at the start and looking east
     * Result: Carol has placed all the beepers that were there at the start into their respective cells
     */

    private void distributeBeepersAcrossCells() throws Exception {
        while (frontIsClear()) {
            pickBeeper();
            if (noBeepersPresent()) {
                putBeeper();
                turnAround();
            }
            if (frontIsClear()) {
                move();
            }
            while (beepersPresent() && frontIsClear()) {
                move();
            }
            while (noBeepersPresent()) {
                putBeeper();
                turnAround();
                returnToStart();
            }
        }
        if (frontIsBlocked()) {
            turnAround();
        }
    }

    /**
     * Precondition: Carol is standing at the starting point and looking east
     * Result: Carol removed all the extra beepers except for the one in the center.
     */

    private void removesExcessBeepers() throws Exception {
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
        move();
        while (beepersPresent()) {
            pickBeeper();
            if (frontIsClear()) {
                move();
            }
        }
    }
}