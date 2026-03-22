import java.awt.Point;
import java.util.ArrayList;

/**
 * Represents a zombie in the simulation.
 *
 * Zombies can move around the board and infect nearby humans.
 * If a zombie finds a human in a neighboring cell, it converts
 * that human into a zombie.
 *
 * @author Lay Leehout
 * @version 1.0
 */
public class xZombie extends xHuman {

    /**
     * Create a human at a specific position.
     *
     * @param x the x position
     * @param y the y position
     */
    public xZombie(int x, int y) {
        super(x, y);
    }

    /**
     * Returns the map symbol for a zombie.
     *
     * @return the string "Z"
     */
    public String toString() {
        return "Z";
    }

    /**
     * Searches for a human at the given position in the human list.
     *
     * @param x the row to search
     * @param y the column to search
     * @param humanList the list of humans
     * @return the index of the human if found, or -1 if not found
     */

}