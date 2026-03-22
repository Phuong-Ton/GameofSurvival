import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Controller class ( ActionListener)
 */
public class xLifeController implements ActionListener {

    private xLifeModel myGrid;
    private xLifeView view;
    private Timer gameTimer;

    public xLifeController(xLifeModel model, xLifeView view) {

        this.myGrid = model;
        this.view = view;

        // Create timer
        gameTimer = new Timer(50, this);
        gameTimer.setActionCommand("Timer");

        // Add listeners (same as your code)
        view.stickButton.addActionListener(this);
        view.closeButton.addActionListener(this);
        view.animateButton.addActionListener(this);
        view.resetButton.addActionListener(this);
        view.loadButton.addActionListener(this);
        view.saveButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String buttonText = event.getActionCommand();

        if(buttonText.equals("Animate")) {
            if (gameTimer.isRunning()) {
                gameTimer.stop();
            } else {
                gameTimer.start();
            }

        } else if(buttonText.equals("Stick")) {

            gameTimer.stop();
            myGrid.update();
            myGrid.repaint();
            updateScore();

        } else if(buttonText.equals("Timer")) {

            myGrid.update();
            myGrid.repaint();
            updateScore();

            if(myGrid.getRemainMoves() <= 0){
                gameTimer.stop();
            }

        } else if(buttonText.equals("Close")) {

            System.exit(0);

        } else if(buttonText.equals("Save")) {

            try {
                saveMapDialog();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if(buttonText.equals("Load Map")) {

            xLifeMain.curMapFile = geFile();

            if(xLifeMain.curMapFile != null){
                gameTimer.stop();
                try {
                    myGrid.reset(xLifeMain.curMapFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                updateScore();
                view.pack();
                view.setLocationRelativeTo(null);
                view.repaint();
                view.revalidate();
            }

        } else if(buttonText.equals("Reset")) {

            try {
                gameTimer.stop();
                myGrid.reset(xLifeMain.curMapFile);
                updateScore();
                myGrid.repaint();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // SAME METHOD (no change)
    public void updateScore() {
        view.scoreLabel.setText("<html>Humans: " + myGrid.getHumanPoint() +
                " vs Zombies: " + myGrid.getZombiePoint() +
                "<br> End Game after: "+ myGrid.getRemainMoves() +" steps </html>");
    }

    public String geFile() {
        FileDialog fd = new FileDialog(view, "Choose a file", FileDialog.LOAD);
        fd.setVisible(true);

        String directory = fd.getDirectory();
        String file = fd.getFile();

        if (file != null) {
            return directory + file;
        }
        return null;
    }

    public void saveMapDialog() throws IOException {

        FileDialog dialog = new FileDialog(view, "Save Map As", FileDialog.SAVE);
        dialog.setVisible(true);

        String directory = dialog.getDirectory();
        String fileName = dialog.getFile();

        if (fileName != null) {
            if (!fileName.endsWith(".txt")) {
                fileName = fileName + ".txt";
            }

            File file = new File(directory, fileName);

            try (FileWriter fw = new FileWriter(file)) {
                fw.write(myGrid.getRows() + "\n");
                fw.write(myGrid.getCols() + "\n");
                fw.write(myGrid.toString());
            }

            JOptionPane.showMessageDialog(view,
                    "Map saved to " + file.getAbsolutePath());
        }
    }
}