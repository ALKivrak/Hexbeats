import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;


public class ScoreBoard extends JFrame
{
	private java.awt.Container pane;
	private JButton back;
	private static JTextField scores;
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;

	private static ArrayList<NameAndScore> scoreValues = new ArrayList<NameAndScore>();

	public ScoreBoard()
	{
		Font font = new Font("SansSerif", Font.BOLD, 50);
		pane = getContentPane();
		pane.setLayout(new GridLayout(2, 1));
		setTitle("Score Board");
		setVisible(true);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		back = new JButton("Return");
		back.setFont(font);
		scores = new JTextField();
		scores.setFont(font);
		scores.setText(scoreValues.toString());
		back.addActionListener(new Action());
		pane.add(back, BorderLayout.SOUTH);
		pane.add(scores, BorderLayout.NORTH);
	}

	public static void addScore(final NameAndScore nameAndScore) {
		scoreValues.add(nameAndScore);
	}

	static class Action implements ActionListener
	{
		    public void actionPerformed (ActionEvent e)
		    {
		    	new MainMenuWindow(); // performs action if button is pressed
		    }
	}
}
