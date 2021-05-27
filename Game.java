//Andrew Kivrak
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JFrame
{
	
   private static JButton button;
   private static JTextField field; // for boolean
   private JTextField hex; // for hexidecimal
   private static boolean stoper = false;
   private static boolean checker = true;
   private static boolean starter = false;
   private static String bin = ""; // this will be the binary value
   private static int strikes = 0;
   private static int hex2 = 0; // this will be the target value in hexidecimal
   private static int nibble = 4;
   private static int sec = 0;
   private static int tempo = 0;
   private static int score = 0;
   private ActionListener beater = new Action();
   private static String hex3 = dectohex(hex2); // converts integer to hexidecimal
   private JMenuBar menuBar;
   /**
      init method
   */
   private void createGUI()
   {
	   Font font2 = new Font("SansSerif", Font.BOLD, 80);
	   
       JLabel appletLabel = new JLabel("Game");
       add( appletLabel );
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(600, 600);
       button = new JButton(); ///create button
 	   button.addActionListener(beater); //assign button an action
 	  
 	   field = new JTextField(); //create text field for user
 	   field.setFont(font2);
 	   field.setEditable(false); // disable cheating
 	   hex = new JTextField();
 	   hex.setEditable(false);
 	   hex.setFont(font2);
 	   button.setFont(font2);
 	   hex.setText(hex3);  
 	   setLayout(new BorderLayout());
 	   setVisible(true);
 	   add(button, BorderLayout.CENTER);
	   add(field, BorderLayout.SOUTH);
	   add(hex, BorderLayout.NORTH);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   inMenuBar();
   }
   
   private void inMenuBar() {
	   JMenu file;
	   JMenuItem quit;
	   file = new JMenu("File");
	   menuBar = new JMenuBar();
	   quit = new JMenuItem("Quit");
	   quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	   file.add(quit);
	   menuBar.add(file);
	   setJMenuBar(menuBar);
   }
   
   public Game(int speed)
   {
	  createGUI();
      // Create a layout manager.
	  tempo = speed;
	  metro(tempo);
   }
   public Game()
   {
	  createGUI();
      // Create a layout manager.
	  tempo = 1000;
	  metro(tempo);
   }
   public void metro(int speed)
   {
	   score = 0;

	   int beat = speed;
	   Timer timer = new Timer();
		  timer.scheduleAtFixedRate(new TimerTask()
		  {
			int i = 0;
			@SuppressWarnings("deprecation")
			public void run() {
				   int k = i;
				   String binint = bin;
				   if((k <= nibble*hex3.length()) && bin.length() < nibble*hex3.length()) // if button not pressed in time
				   {
						  bin = field.getText() + "0"; //add zero to binary string
						  binint += bin;
						  field.setText(bin);
						  checker = true;
						  sec++;
				  }
				  if(k == (nibble*hex3.length())) // clear text field
				  {	 
					  field.setText("");
					  button.removeActionListener(beater);
					  field.setText(dectohex(Integer.parseInt(binint,2))); // shows hexidecimal value
					  if(hex.getText().equals(field.getText())) // tests to see if binary value is = to hex value
					  {
						  button.setLabel("Correct");
						  button.setForeground(Color.GREEN);
						  //hex2 = 1+(int)(Math.random()*32);
						  hex2 = 1+(int)(Math.random()*15);
						  //sec = 0;
						  score++;
					  }
					  else
					  {
						  button.setLabel("Incorrect");
						  button.setForeground(Color.RED);
						  strikes++;
						  //sec = 0;
					  }
				  }
				  i++;
				  // for resting the field for binary
				  if(k == nibble*hex3.length() || k == bin.length())
				  {
					  stoper = true;
				  }
				  if(k == (nibble*hex3.length()+1))
				  {
					  //i = 0;
					  //sec = 0;
					  //stoper = false;
					  //starter = true;
					  button.setLabel("");
					  //button.addActionListener(beater);
					  field.setText(bin);
					  hex.setText("");
					  hex3 = dectohex(hex2);
					  hex.setText(hex3);
					  bin = "";  
					  field.setText(bin);
				  }
				  if(k == (nibble*hex3.length()+2))
				  {
					  i = 0;
					  k = 0;
					  sec = 0;
					  stoper = false;
					  starter = true;
					  button.addActionListener(beater);
				  }
				  if(starter == true) // if button not pressed in time
				   {
						  bin = "0" + field.getText(); //add zero to binary string
						  binint += bin;
						  field.setText(bin);
						  checker = true;
						  starter = false;
						  k++;
						  i++;
						  sec++;
				  }
				  if(strikes >= 3) // three wrong answers = game over and will stop
				  {
					  Font font = new Font("SansSerif", Font.BOLD, 30);
					  button.addActionListener(beater);
					  timer.purge();
					  timer.cancel();
					  k = 0;
					  i = 0;
					  sec = 0;
					  stoper = true;
					  button.setFont(font);
					  button.setLabel("Game Over:Your score is " + score);
					  button.setForeground(Color.BLUE);

					  ScoreBoard.addScore(score);
				  }
				if(bin.length() <= nibble*hex3.length() && stoper == false)
				{
				  PlaySound();
				}
			}	
			  
		  },beat,beat);
   }
   // This method is for making the hexidecimal value for the target the player has to make
   public static String dectohex(int dec)
	{
	  if(dec == 0)
		  return "0";
	  int decnum = dec, rem;
     String hexdecnum="";
	  char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		while(decnum>0)
     {
         rem = decnum%16;
         hexdecnum = hex[rem] + hexdecnum;
         decnum = decnum/16;
     }
		return hexdecnum;
	}
   // every button click will make a 1 instead of a 0
   static class Action implements ActionListener
   {
 	    public void actionPerformed (ActionEvent e)
 	    {
 	    	if(strikes == 3)
 	    	{
 	    		bin = "";
 	    		strikes = 0;
 	    		hex2 = 0;
 	    		nibble = 4;
 	    		sec = 0;
 	    		stoper = false;
 	    		hex3 = dectohex(hex2);
 	    		new MainMenuWindow();
 	    	}
 	    	else if(bin.length() > 0 && checker == true)
 	    	{
 	    			bin = field.getText();
 	 	    		bin = bin.substring(bin.length()-sec,bin.length()-1) + "1";
 	 	    		field.setText(bin);
 	 	    		checker = false;
 	    	}
 	    }
   }
   static class Action2 implements ActionListener
   {
 	    public void actionPerformed (ActionEvent e)
 	    {
 	    	button = (JButton)e.getSource();		
 			//frame.dispose();		
 	    }
   }
   public static synchronized void PlaySound() 
   {
           new Thread(new Runnable() 
           {
               public void run() 
               {
                   try
                   {
                       Clip clip = AudioSystem.getClip();
                       AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("Beater.wav"));
                       clip = AudioSystem.getClip();
                       clip.open(inputStream);
                       clip.start(); 
                   } 
                   catch (Exception e) 
                   {
                       System.err.println(e.getMessage());
                   }
               }
           }).start();
       }
   public static void main(String[] argv) throws Exception {
		  new Game(tempo);
	  }
}