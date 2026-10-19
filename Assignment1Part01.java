package com.shpp.p2p.cs.khavryliuk.assignment1;

public class Assignment1Part01 extends SuperKarel {
    public void run() throws Exception {
        while (frontIsClear()) {
            createColumnOfBeepers();
            returnToFirstLine();
            moveToNextColumn();
        }
        if (frontIsBlocked()) {
            checkAndCreatingLastColumn();
        }
    }

    /**
    Precondition: Karel is facing east.
    Result: Karel has created a column of beepers and is facing north.
     */

    private void createColumnOfBeepers() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
                move();
            } else {
                move();
            }
        }
        if (frontIsBlocked() && noBeepersPresent()) {
            putBeeper();
        }
    }

    /**
     Carol returns to the front row and looks toward the east
     */
    private void returnToFirstLine() throws Exception {
        turnRight();
        if (frontIsClear()) {
            move();
        }
        turnRight();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    /**
    Precondition: none
    Karel takes three steps forward to make the next column of beepers.
     */

    private void moveToNextColumn() throws Exception {
        for (int i = 0; i < 3 && frontIsClear(); i++) {
            move();
        }
    }

    /**
     Carol checks whether it is necessary to create the last column, and if so, he creates it
     */

    private void checkAndCreatingLastColumn() throws Exception {
        turnAround();
        if (frontIsClear()) {
            move();
        }
        if (noBeepersPresent() && frontIsClear()) {
            move();
            if (noBeepersPresent() && frontIsClear()) {
                move();
                if (noBeepersPresent()) {
                    turnAround();
                    while (frontIsClear()) {
                        move();
                    }
                    createColumnOfBeepers();
                }
            }
        } else {
            turnAround();
            createColumnOfBeepers();
        }
    }

}
