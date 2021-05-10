import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

public class ScoreBoard extends JFrame
{
	private java.awt.Container pane;
	private JButton back;
	private static JTextField scores;
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	
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
		back.addActionListener(new Action());
		pane.add(back, BorderLayout.SOUTH);
		pane.add(scores, BorderLayout.NORTH);
	}
	static class Action implements ActionListener
	{
		    public void actionPerformed (ActionEvent e)
		    {
		    	new MainMenuWindow(); // performs action if button is pressed
		    }
	}
}
