//Andrew Kivrak
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Options extends JFrame{
	private java.awt.Container pane;
	private static JRadioButton tempo1;	
	private static JRadioButton tempo2;	
	private static JRadioButton tempo3;	
	private static JRadioButton tempo4;	
	private static JRadioButton tempo5;	
	private static JRadioButton tempo6;
	private JButton back;
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 600;
	public static int speed = 1000;
	public Options()
	{
		Font font = new Font("SansSerif", Font.BOLD, 50);
		
		tempo1 = new JRadioButton("1");
		tempo1.setFont(font);
		
		tempo2 = new JRadioButton("2");
		tempo2.setFont(font);
		
		tempo3 = new JRadioButton("3");
		tempo3.setFont(font);
		
		tempo4 = new JRadioButton("4");
		tempo4.setFont(font);
		
		tempo5 = new JRadioButton("5");
		tempo5.setFont(font);
		
		tempo6 = new JRadioButton("6");
		tempo6.setFont(font);
		
		
		
		setTitle("Options");
		
		pane = getContentPane();
		pane.setLayout(new GridLayout(7, 1));
		
		pane.add(tempo1, BorderLayout.NORTH);
		pane.add(tempo2, BorderLayout.NORTH);
		pane.add(tempo3, BorderLayout.NORTH);
		pane.add(tempo4, BorderLayout.NORTH);
		pane.add(tempo5, BorderLayout.NORTH);
		pane.add(tempo6, BorderLayout.NORTH);
		back = new JButton("Apply");
		back.addActionListener(new Action());
		setVisible(true);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		pane.add(back, BorderLayout.SOUTH);
		back.setFont(font);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	static class Action implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	if(tempo1.isSelected())
		    		speed = 1000;
		    	else if(tempo2.isSelected())
		    		speed = 900;
		    	else if(tempo3.isSelected())
		    		speed = 800;
		    	else if(tempo4.isSelected())
		    		speed = 700;
		    	else if(tempo5.isSelected())
		    		speed = 600;
		    	else if(tempo6.isSelected())
		    		speed = 500;
		    	new MainMenuWindow(speed); // performs action if button is pressed
		    }
	  }
	
	public static void main(String[] args)
	{
		new Options();
	}
}
