package com.shpp.p2p.cs.khavryliuk.assignment1;

public class Assignment1Part04 extends SuperKarel {
    public void run() throws Exception {
        while (frontIsClear()) {
            checkAndCleans();
            movePastTheWall();
            if (frontIsBlocked()) {
                checkAndCleans();
                turnRight();
                move();
                turnLeft();
            }

        }
    }

    /*
    Precondition: None
    Result: Carol checked to see if the beeper was in the center compartment,
    and if it wasn't, he cleaned the reactor from top to bottom.
    */

    private void checkAndCleans() throws Exception {
        if (noBeepersPresent()) {
            turnLeft();
            move();
            while (beepersPresent()) {
                pickBeeper();
            }
            turnAround();
            move();
            move();
            while (beepersPresent()) {
                pickBeeper();
            }
            turnAround();
            move();
            turnRight();
        }
    }

    private void movePastTheWall() throws Exception {
        move();
        move();
    }
}