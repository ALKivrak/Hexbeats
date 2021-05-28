import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;


public class EnterYourName extends JFrame
{
    private java.awt.Container pane;
    private JButton back;
    private static JTextField name;
    private static JTextField instruction;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 300;

    private static int score;

    public EnterYourName()
    {
        Font font = new Font("SansSerif", Font.BOLD, 50);
        pane = getContentPane();
        pane.setLayout(new BorderLayout());
        setTitle("Enter Your Name");
        setVisible(true);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        back = new JButton("Done");
        back.setFont(font);
        name = new JTextField();
        name.setFont(font);
        name.setText("Player");
        instruction = new JTextField();
        instruction.setFont(font);
        instruction.setText("Enter your name:");
        instruction.setEditable(false);
        back.addActionListener(new Action());
        pane.add(instruction, BorderLayout.NORTH);
        pane.add(name, BorderLayout.CENTER);
        pane.add(back, BorderLayout.SOUTH);
    }

    public static void trackScore(final int playerScore) {
        score = playerScore;
    }

    static class Action implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            ScoreBoard.addScore(new NameAndScore(score, name.getText()));

            new MainMenuWindow(); // performs action if button is pressed
        }
    }
}
