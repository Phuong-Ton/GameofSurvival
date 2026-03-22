import java.io.FileNotFoundException;
/**
 * This is the main class of the program.
 *
 * It starts the game and connects all parts together:
 * - Model (game logic)
 * - View (GUI)
 * - Controller (handles user actions)
 */
public class xLifeMain {
    /** The map file used to start the game */
    public static String curMapFile = "xMapSmall.txt";
    /**
     * Endpoint of this simulation
     *
     * It:
     * - Sets the UI style
     * - Creates the game model
     * - Creates the GUI
     * - Connects the controller
     *
     * @param args not used
     * @throws FileNotFoundException if the map file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        int remainMove = 50;
        // Model
        xLifeModel myGrid = new xLifeModel(curMapFile, remainMove);

        // View
        xLifeView view = new xLifeView(myGrid, remainMove);

        // Controller (your listener)
        new xLifeController(myGrid, view);
    }
}
