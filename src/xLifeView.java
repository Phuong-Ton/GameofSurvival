import javax.swing.*;
import java.awt.*;

/**
 * View class (GUI)
 */
public class xLifeView extends JFrame {

    public JFrame window;
    public JButton loadButton, animateButton, stickButton, resetButton, saveButton, closeButton;
    public JLabel scoreLabel;

    public xLifeView(xLifeModel myGrid, int remainMove) {
        window = this;
        setTitle("Game of Survival");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons
        loadButton = new JButton("Load Map");
        animateButton = new JButton("Animate");
        stickButton = new JButton("Stick");
        resetButton = new JButton("Reset");
        saveButton = new JButton("Save");
        closeButton = new JButton("Close");

        String rulesText = "<html>" +
                " +1 Human Point if Soldier kills Zombie: <br>" +
                " +1 Human Point if Human/Zombie reach Safezone <br>" +
                " +1 Zombie Point if Zombie tags Human" +
                "</html>";

        scoreLabel = new JLabel("<html>Humans: 0 vs Zombies: 0 <br> End Game after: "
                + remainMove + " steps </html>");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel rulesLabel = new JLabel(rulesText);
        rulesLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        rulesLabel.setBorder(BorderFactory.createTitledBorder("Rules: Game ends when Steps reach 0 "));

        JPanel topPanel = new JPanel(new GridLayout(0,1));

        topPanel.add(scoreLabel,BorderLayout.NORTH);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(rulesLabel,BorderLayout.SOUTH);

        JPanel midPanel = new JPanel();
        midPanel.add(myGrid);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(loadButton);
        bottomPanel.add(animateButton);
        bottomPanel.add(stickButton);
        bottomPanel.add(resetButton);
        bottomPanel.add(saveButton);
        bottomPanel.add(closeButton);

        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}