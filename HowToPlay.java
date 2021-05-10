//Andrew Kivrak
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class HowToPlay extends JFrame
{
	private JTextArea howtoplay;
	private JButton back;
	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 600;
	
	@SuppressWarnings("deprecation")
	public HowToPlay()
	{
		setTitle("HexBeats");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		howtoplay = new JTextArea();
		back = new JButton();
		howtoplay.setText("Welcome to Hex Beats!\r\n" + 
				"This game is for learning binary to hexadecimal conversions using rhythm. The first four clicks are preparatory clicks to get the tempo.\n "
				+ "To play, click the button when you hear a beat for a 1 and do not click if you want a 0.\n"
				+ " Every beat without a click will be a 0. For example, if the hex value is 4, you need 0100, and for F, you need 1111.\n"
				+ " If the hex value is equal the binary value, you score a point and your hex value target will increase by 1.\n "
				+ "If you miss, you get a strike and you get to try the same value again. If you get three strikes, the game is over.\n "
				+ "The scoring is determined by how high you can count in hex.\n" + 
				"Hint: every hex value is one nibble, 2 nibbles equal a byte, and 2 bytes equal a word.\n"
				+ " Here are the values of hex from 0 to 16. 0,1,2,3,4,5,6,7,8,9, A, B, C, D, E, F,10.\r\n" + 
				"A = 10\r\n" + 
				"B = 11\r\n" + 
				"C = 12\r\n" + 
				"D = 13\r\n" + 
				"E = 14\r\n" + 
				"F = 15\r\n" + 
				"10 = 16\r\n" + 
				"");
		howtoplay.setFont(new Font("Serif",Font.PLAIN,30));
		howtoplay.setEditable(false);
		add(howtoplay, BorderLayout.NORTH);
		add(back);
		back.setLabel("Back");
		back.addActionListener(new Action());
		setVisible(true);
	}
	static class Action implements ActionListener
	  {
		    public void actionPerformed (ActionEvent e)
		    {
		    	new MainMenuWindow(); // performs action if button is pressed
		    }
	  }
	public static void main(String[] args)
	{
		new HowToPlay();
	}
}
