//Andrew Kivrak
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainMenuWindow extends JFrame{
	private java.awt.Container pane;
	private JButton start;
	private JButton options;
	private JButton scoreboard;
	private JButton howtoplay;
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 500;
	private static int beat = 0;
	public MainMenuWindow()
	{
		Font font = new Font("SansSerif", Font.BOLD, 50);
		setTitle("HexBeats");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLayout(new BorderLayout());
		pane = getContentPane();
		pane.setLayout(new GridLayout(2, 2));
		start = new JButton("Start");
		start.addActionListener(new Action3());
		howtoplay = new JButton("How To Play");
		howtoplay.addActionListener(new Action2());
		new JButton("Exit");
		options = new JButton("Options");
		options.addActionListener(new Action4());
		scoreboard = new JButton("Score Board");
		scoreboard.addActionListener(new Action5());
		pane.add(start, BorderLayout.NORTH);
		pane.add(howtoplay, BorderLayout.NORTH);
		pane.add(options, BorderLayout.SOUTH);
		pane.add(scoreboard, BorderLayout.SOUTH);
		start.setFont(font);
		howtoplay.setFont(font);
		options.setFont(font);
		scoreboard.setFont(font);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public MainMenuWindow(int tempo)
	{
		beat = tempo;
		Font font = new Font("SansSerif", Font.BOLD, 50);
		setTitle("HexBeats");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLayout(new BorderLayout());
		pane = getContentPane();
		pane.setLayout(new GridLayout(2, 2));
		start = new JButton("Start");
		start.addActionListener(new Action());
		howtoplay = new JButton("How To Play");
		howtoplay.addActionListener(new Action2());
		new JButton("Exit");
		options = new JButton("Options");
		options.addActionListener(new Action4());
		scoreboard = new JButton("Score Board");
		scoreboard.addActionListener(new Action5());
		pane.add(start, BorderLayout.NORTH);
		pane.add(howtoplay, BorderLayout.NORTH);
		pane.add(options, BorderLayout.SOUTH);
		pane.add(scoreboard, BorderLayout.SOUTH);
		start.setFont(font);
		howtoplay.setFont(font);
		options.setFont(font);
		scoreboard.setFont(font);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	static class Action implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new Game(beat); // performs action if button is pressed
		    }
	  }
	static class Action2 implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new HowToPlay(); // performs action if button is pressed
		    }
	  }
	static class Action3 implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new Game(); // performs action if button is pressed
		    }
	  }
	static class Action4 implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new Options(); // performs action if button is pressed
		    }
	  }
	static class Action5 implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new ScoreBoard(); // performs action if button is pressed
		    }
	  }
	public static void main(String[] args)
	{
		new MainMenuWindow();
	}
}
