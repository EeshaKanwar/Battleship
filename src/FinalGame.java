//Name: Eesha Kanwar
//Date: December 13, 2018
//Purpose: To make a game using widgets and arrays (GUI Design)
//Title: Battleship game

/*Picture Sources ----

 TARGET --  target.png - http://www.iconarchive.com/show/beautiful-flat-icons-by-elegantthemes/target-icon.html

 WATER --       sub0 - https://commons.wikimedia.org/wiki/File:Blue_water,_Lake_Tahoe.jpg

 SUBMARINES --  sub1 -  http://www.iconarchive.com/show/beautiful-flat-one-color-icons-by-elegantthemes/submarine-icon.html
        sub2 -  http://www.iconarchive.com/show/beautiful-flat-icons-by-elegantthemes/submarine-icon.html
        sub3 -  http://www.iconarchive.com/show/brilliant-transportation-icons-by-iconshock/yellow-submarine-icon.html
        sub4 -  http://www.iconarchive.com/show/aquatic-icons-by-iconshock/submarine-icon.html
        sub5 -  http://www.iconarchive.com/show/flat-icons-by-flat-icons.com/Submarine-icon.html

 Blank --       sub6 - Made on PowerPoint

 SHIPS -- 
        sub8, sub9, sub10 - http://www.iconarchive.com/show/transporter-icons-by-icons-land/Container-Ship-Top-Red-icon.html
        sub11, sub12, sub13 - http://www.iconarchive.com/show/crystal-clear-icons-by-everaldo/App-battleship-boat-icon.html
        sub14, sub15, sub16 - http://www.iconarchive.com/show/transporter-icons-by-icons-land/Container-Ship-Right-Red-icon.html
 */

//Libraries
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.applet.Applet;
import java.applet.*;

public class FinalGame extends Applet implements ActionListener
{
	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5; //the two screens
	CardLayout cdLayout = new CardLayout ();

	//grid
	int row = 8;
	int col = 11;
	JButton a[] = new JButton [row * col];

	int sub[] [] = {{6, 6, 6, 1, 6, 6, 6, 6, 3, 6, 6}, //Original Answer Array - 6 is blank, the other numbers are ships or submarines.
			{8, 9, 10, 6, 6, 6, 5, 6, 6, 6, 6}, 
			{6, 6, 6, 6, 4, 6, 6, 6, 13, 6, 6},
			{6, 6, 3, 6, 6, 6, 6, 6, 12, 6, 6}, 
			{2, 6, 6, 6, 6, 5, 6, 6, 11, 6, 6}, 
			{6, 6, 6, 1, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 3, 6, 6, 6, 6, 2, 6, 6, 6}, 
			{4, 6, 6, 6, 14, 15, 16, 6, 6, 6, 6}};

	int water [] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//Original Array - Water on the screen in the beginning
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	int water1 [][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//LEVEL 1 -- water
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	int water2 [][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//LEVEL 2 -- water
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	int water3 [][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//LEVEL 3 -- water
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	int sub1 [][] = {{6, 6, 6, 1, 6, 6, 6, 6, 3, 6, 6}, //LEVEL 1 -- 11 submarines and 3 ships (Answer array)
			{8, 9, 10, 6, 6, 6, 5, 6, 6, 6, 6}, 
			{6, 6, 6, 6, 4, 6, 6, 6, 13, 6, 6},
			{6, 6, 3, 6, 6, 6, 6, 6, 12, 6, 6}, 
			{2, 6, 6, 6, 6, 5, 6, 6, 11, 6, 6}, 
			{6, 6, 6, 1, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 5, 6, 6, 6, 6, 2, 6, 6, 6}, 
			{4, 6, 6, 6, 14, 15, 16, 6, 6, 6, 6}};

	int sub2 [][] = {{1, 6, 6, 6, 4, 6, 6, 6, 6, 6, 2},//LEVEL 2 -- 8 submarines, 2 ships (Answer array)
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 6, 14, 15, 16, 6, 6, 6, 6, 6},
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
			{3, 6, 6, 6, 6, 6, 6, 13, 6, 6, 3}, 
			{6, 6, 6, 5, 6, 6, 6, 12, 6, 6, 6}, 
			{6, 6, 6, 6, 6, 6, 6, 11, 6, 6, 6}, 
			{2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5}};

	int sub3 [][] =  {{6, 6, 6, 6, 6, 3, 6, 6, 6, 6, 6}, //LEVEL 3 -- 5 submarines, 1 ship  (Answer array)
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 6, 1, 6, 6, 6, 6, 6, 6, 2},
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 6, 6, 6, 6, 8, 9, 10, 6, 6}, 
			{6, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
			{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}};

	//Global Variables
	int level = 1; //a variable to track which level is displayed
	int target=-1;
	int points = 0;//Variable to track Points
	JLabel showPoint;
	int Move=0;//Variable to track number of moves
	JProgressBar pr;
	int i = 0;//Variable to track the progress bar
	JLabel moves;
	JButton next;
	AudioClip soundFile;

	public void init ()
	{
		//Background music
		soundFile = getAudioClip (getDocumentBase (), "soundtrack.wav");
		//this attaches the sound file battleship soundtrack
		soundFile.loop ();
		//put the sound on repeat

		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		//calling the screen methods
		screen1 ();
		screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		//same size of all the screen
		resize (600, 670);
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}

	public void screen1 ()//Splash Screen
	{ 
		//screen 1 is set up.
		card1 = new Panel ();
		card1.setBackground(new Color(151,210,230)); 

		JLabel title = new JLabel ("Welcome to the World of Warships Blitz!");
		title.setFont (new Font ("Times New Roman", Font.BOLD, 30));
		title.setForeground(new Color(39,39,39));

		//Panels used to arrange the buttons on the screen
		Panel g = new Panel(new GridLayout(1,2));
		Panel p1 = new Panel();
		p1.setBackground(new Color(39,39,39));

		JButton next = new JButton ("Instructions");
		next.setFont (new Font ("Times New Roman", Font.BOLD, 14));
		next.setActionCommand ("s2");
		next.addActionListener (this);
		next.setBorderPainted(true);

		JButton play = new JButton ("Play");
		play.setFont (new Font ("Times New Roman", Font.BOLD, 14));
		play.setActionCommand ("play");
		play.addActionListener (this);
		play.setBorderPainted(true);

		JLabel pic = new JLabel (createImageIcon ("battleship.png"));

		//adding the widgets
		card1.add (title);
		card1.add (pic);
		card1.add (g);
		g.add(p1);
		p1.add(next);
		p1.add(play);
		p_card.add ("1", card1);
	}

	public void screen2 ()//Game Instructions Screen
	{ 
		//screen 2 is set up.
		card2 = new Panel ();
		card2.setBackground(new Color(151,210,230));

		JButton ins = new JButton (createImageIcon ("Instruction.png"));
		ins.setBackground(new Color(151,210,230)); 
		ins.setActionCommand ("s3");
		ins.addActionListener (this);

		JButton tip = new JButton ("TIP");
		tip.setFont (new Font ("Times new Roman", Font.BOLD, 30));
		tip.setBorder(new LineBorder(new Color(39,39,39)));

		JLabel Tip = new JLabel (": A Give Up Button is there but it will not show you the answer,");
		Tip.setFont (new Font ("Times New Roman", Font.PLAIN, 19));
		JLabel Tips = new JLabel (" but rather you will just loose the whole game.");
		Tips.setFont (new Font ("Times New Roman", Font.PLAIN, 19));

		//adding the widgets
		card2.add (ins);
		card2.add (tip);
		card2.add (Tip);
		card2.add (Tips);
		p_card.add ("2", card2);
	}

	public void screen3 ()//Game Screen
	{ 
		//screen 3 is set up.
		card3 = new Panel ();
		card3.setBackground(new Color(151,210,230)); 

		JLabel title = new JLabel ("SEA BATTLE BEGINS!!");
		title.setFont (new Font ("Meriwhether", Font.BOLD, 35));
		title.setForeground(new Color(39,39,39));
		title.setBorder(new LineBorder(new Color(39,39,39)));

		//Panels used to arrange the buttons on the screen
		Panel ge = new Panel (new GridLayout (4, 1));
		Panel p1 = new Panel ();
		p1.setBackground (new Color (151,210,230));
		Panel p2 = new Panel ();
		p2.setBackground(new Color (151,210,230));
		Panel p3 = new Panel ();
		p3.setBackground(new Color(151,210,230));
		Panel p4 = new Panel ();
		p4.setBackground(new Color(151,210,230));
		Panel p5 = new Panel ();
		p5.setBackground(new Color(151,210,230));
		p5.setPreferredSize((new Dimension(50,15)));

		next = new JButton ("Next Level");
		next. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		next.setActionCommand ("s4");
		next.addActionListener (this);
		next.setEnabled(false);

		JButton launch = new JButton ("LAUNCH");
		launch.addActionListener(this);
		launch.setActionCommand("launch");
		launch. setFont (new Font ("Meriwhether", Font.BOLD, 18));

		showPoint = new JLabel("Your Score: "+points);
		showPoint.setFont (new Font ("Times new Roman", Font.ITALIC, 20));
		showPoint.setForeground(Color.black);

		moves = new JLabel("Your Moves: "+Move);
		moves.setFont (new Font ("Times new Roman", Font.ITALIC, 20));
		moves.setForeground(Color.black);

		JButton Instruct = new JButton ("Instructions");
		Instruct. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		Instruct.addActionListener(this);
		Instruct.setActionCommand("Instruct");

		JButton hint = new JButton ("Hint");
		hint. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		hint.addActionListener(this);
		hint.setActionCommand("hint");

		JButton reset = new JButton ("Start Again");
		reset. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		reset.addActionListener(this);
		reset.setActionCommand("Reset");

		pr = new JProgressBar (0, 0, 100);
		pr.setValue (0);
		pr.setStringPainted (true);

		JButton giveup = new JButton ("Give Up");
		giveup. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		giveup.addActionListener(this);
		giveup.setActionCommand("giveup");

		JButton save = new JButton("Save"); 
		save. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		save.addActionListener(this); 
		save.setActionCommand("save");

		JButton open = new JButton("Open");
		open. setFont (new Font ("Meriwhether", Font.BOLD, 13));
		open.addActionListener(this);
		open.setActionCommand("open");

		Panel g = new Panel (new GridLayout (row, col));
		for (int m = 0 ; m < a.length ; m++)
		{
			a [m] = new JButton (" ");
			a [m].setPreferredSize(new Dimension(216,162));
			a [m].addActionListener (this);
			a [m].setActionCommand ("" + m);
			g.add (a [m]);
		}
		//Set up grid
		Panel p = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{ //take out when you've got pictures
				a [move] = new JButton  (createImageIcon ("sub0.png"));
				//add in when you have pictures
				//a [move] = new JButton (createImageIcon ("sub" + sub [i] [j] + ".png"));
				a [move].setPreferredSize (new Dimension (54, 54));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				p.add (a [move]);
				move++;
			}
		}
		//adding all the widgets
		card3.add (title);
		card3.add (p);
		card3.add(ge);
		ge.add(p1);
		p1.add(moves);
		p1.add(p5);
		p1.add(showPoint);
		ge.add(p2);
		p2.add (reset);
		p2.add (launch);
		p2.add (next);
		ge.add(p3);
		p3.add(Instruct);
		p3.add(hint);
		card3.add (pr);
		p3.add (giveup);
		ge.add(p4);
		p4.add(save);
		p4.add(open);
		p_card.add ("3", card3);
	}

	public void screen4 ()//Winning Screen
	{ 
		//screen 4 is set up.
		card4 = new Panel ();
		card4.setBackground (new Color(151,210,230));

		//Panels used to arrange the buttons on the screen
		Panel ge = new Panel (new GridLayout (1, 1));
		Panel p1 = new Panel ();
		p1.setBackground (new Color (39,39,39));
		Panel p2 = new Panel ();
		p2.setBackground (new Color (151,210,230));
		p2.setPreferredSize(new Dimension(600,15));

		JButton next = new JButton ("Back to Introduction?");
		next. setFont (new Font ("Times New Roman", Font.BOLD, 16));
		next.setBorderPainted(true);
		next.setActionCommand ("s5");
		next.addActionListener (this);

		JButton end = new JButton ("Quit?");
		end. setFont (new Font ("Times New Roman", Font.BOLD, 16));
		end.setBorderPainted(true);
		end.setActionCommand ("s6");
		end.addActionListener (this);

		JButton replay = new JButton ("Play Again");
		replay. setFont (new Font ("Times New Roman", Font.BOLD, 16));
		replay.setBorderPainted(true);
		replay.setActionCommand ("replay");
		replay.addActionListener (this);

		JLabel win = new JLabel (createImageIcon ("win.png"));
		win.setBackground(new Color(151,210,230));

		//adding all the widgets
		card4.add (win);
		card4.add(p2);
		card4.add (ge);
		ge.add(p1);
		p1.add (next);
		p1.add (end);
		p1.add (replay);
		p_card.add ("4", card4);
	}

	public void screen5 ()//Loosing Screen
	{ 
		//screen 5 is set up.
		card5 = new Panel ();
		card5.setBackground (new Color(151,210,230));

		JLabel lost = new JLabel (createImageIcon ("lost.png"));
		lost.setBackground(new Color(151,210,230));

		//Panels used to arrange the buttons on the screen
		Panel ge = new Panel (new GridLayout (1, 1));
		Panel p1 = new Panel ();
		p1.setBackground (new Color (39,39,39));
		Panel p2 = new Panel ();
		p2.setBackground (new Color (151,210,230));
		p2.setPreferredSize(new Dimension(600,15));

		JButton next = new JButton ("Back to Introduction?");
		next. setFont (new Font ("Times New Roman", Font.BOLD, 16));
		next.setBorderPainted(true);
		next.setActionCommand ("s1");
		next.addActionListener (this);

		JButton end = new JButton ("Quit?");
		end.setFont (new Font ("Times New Roman", Font.BOLD, 16));
		end.setBorderPainted(true);
		end.setActionCommand ("s6");
		end.addActionListener (this);

		JButton replay = new JButton ("Play Again");
		replay. setFont (new Font ("Times New Roman", Font.BOLD, 16));
		replay.setBorderPainted(true);
		replay.setActionCommand ("replay");
		replay.addActionListener (this);

		//adding all the widgets
		card5.add (lost);
		card5.add (p2);
		card5.add (ge);
		ge.add(p1);
		p1.add(next);
		p1.add (end);
		p1.add(replay);
		p_card.add ("5", card5);
	}

	protected static ImageIcon createImageIcon (String path)
	{ 
		java.net.URL imgURL = FinalGame.class.getResource (path);
		if (imgURL != null)
		{
			return new ImageIcon (imgURL);
		}
		else
		{
			System.err.println ("Couldn't find file: " + path);
			return null;
		}
	}

	//Method to save the game so that it can be played again
	public void save (String filename) { 
		PrintWriter out;
		try {
			out = new PrintWriter (new FileWriter (filename));
			//Level, moves, points, and progress bar is saved for the player
			out.println (""+level);
			out.println (""+Move);
			out.println (""+points);
			out.println (""+i);

			for(int i=0; i<row; i++)
				for (int j=0; j<col; j++) 
					out.println (""+water[i][j]);

			out.close ();
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		} 
	}

	//Method to open the saved game
	public void open(String filename){ 
		BufferedReader in;
		try {
			in = new BufferedReader (new FileReader (filename)); 

			//to open the same level player left off
			String input = in.readLine ();
			level=Integer.parseInt(input);
			level--;
			levelUp();
			System.out.println(""+level);
			//for the player to have same number of moves where he/she left off
			input = in.readLine ();
			Move=Integer.parseInt(input);
			moves.setText("Your Moves: "+Move);
			//for the player to have same number of points where he/she left off
			input = in.readLine ();
			points=Integer.parseInt(input);
			showPoint.setText("     Your Score: "+points);
			//for the player to have same progress bar from where they left off
			input = in.readLine ();
			i=Integer.parseInt(input);
			pr.setValue(i);

			input = in.readLine ();
			for(int i=0; i<row; i++)
				for(int j=0; j<col; j++) {
					water[i][j]=Integer.parseInt(input);
					input = in.readLine ();
				}

			in.close (); 
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e); 
		}
		redraw();
	}

	//Method to update the screen
	public void redraw ()
	{
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [move].setIcon (createImageIcon ("sub"+ water [i] [j] + ".png"));
				move++;
			}
		}
	}

	//Method to check whether the player can move a level up
	public boolean check ()
	{
		if(points>=53 && level ==1)
			return true;
		else if(points>=38 && level ==2)
			return true;
		else if(points>=23 && level ==3)
			return true;
		else 
			return false;
	}

	public void copyOver (int m[][], int n[][])
	{ //copy every element of n into m
		//that changes the level
		for (int i = 0 ; i < row ; i++)
			for (int j = 0 ; j < col ; j++)
				m [i] [j] = n [i] [j];
	}

	//method to change the grids for different levels
	public void levelUp ()  
	{
		level++;
		//sets back the moves,points and progress bar to zero
		Move=0; 
		moves.setText("Your Moves: "+Move);
		points=0;
		showPoint.setText("     Your Score: "+points);
		i=0;
		pr.setValue(0);

		if (level == 1)
		{
			copyOver (water, water1);
			copyOver (sub, sub1);
		}
		else if (level == 2)
		{//Dialog box appears after the player wins the level 1
			JOptionPane.showMessageDialog (null, "Congratulations :)\n"
					+ "You have passed the first level with flying colours!! \n"
					+ "To move on to next level, Press 'OK.'\n "
					+ "And here's a tip for the Next Level - The Progress Bar goes uptill 70% \n"
					+ "When you have your 70%, you can move to the Next Level. Have Fun and Good Luck :)", "YAY! Hooray!!",
					JOptionPane.INFORMATION_MESSAGE);
			next.setEnabled(false);//disables the next level button
			copyOver (water, water2);
			copyOver (sub, sub2);
		}
		else if (level == 3)
		{//Dialog box appears after the player wins the level 2
			JOptionPane.showMessageDialog (null, "Congratulations :)\n"
					+ "You have passed the second level with flying colours too!! \n"
					+ "To move on to next level, Press 'OK.' \n"
					+ "And here's a tip for the Last Level - The Progress Bar goes uptill 40% \n"
					+ "When you have your 40%, you have to click to the Next Level Button again. \n"
					+ "Have Fun and Good Luck :)", "YAY! Hooray!!",
					JOptionPane.INFORMATION_MESSAGE);
			next.setEnabled(false);//disables the next level button
			copyOver (water, water3);
			copyOver (sub, sub3);
		}
		else
		{ //show your final win screen.
			cdLayout.show (p_card, "4");
		}
		//call redraw to update the screen
		redraw ();
	}

	//Reset Button Method that starts everything from the beginning
	public void StartAgain () {

		int input2 = JOptionPane.showConfirmDialog (null, "Are you sure you want to start again?",
				"No going back, if you click yes.", JOptionPane.YES_NO_OPTION);
		if(input2 == JOptionPane.YES_OPTION) {//if they are sure about starting over then, the game just resets
			for (int m = 0 ; m < a.length ; m++)
				a [m].setIcon (createImageIcon ("sub0.png"));//sets the grid back to water
			//sets the points back to zero
			showPoint.setText("     Your Score: 0");
			points = 0;
			//sets the number of moves back to zero
			moves.setText("Your Moves: 0");
			Move = 0;
			//sets the progress bar back to zero
			pr.setValue(0);
			i=0;
			if(input2 == JOptionPane.NO_OPTION) {
				remove(input2);//if they don't want to start again then the dialog box just goes away
			}
		}
	}

	//Hint button method for one different hint in each level
	public void Hint ()
	{
		if(level==1)
			JOptionPane.showMessageDialog (null,"Don't waste your time on the last two coloumns \n"
					+ "as there are diagnol steps of submarines that can destroy your cargo,\n "
					+ "so its better that you destroy them before they destroy you.", 
					"HINT! Read it carefully...", JOptionPane.INFORMATION_MESSAGE);
		else if (level==2)
			JOptionPane.showMessageDialog (null,"Begin your search at the 4 corners, \n"
					+ "and work until you find 2 ships \n "
					+ "as the route to the next level comes after\n "
					+ "you capture 8 submarines and 2 battleships.", 
					"HINT! Read it carefully...", JOptionPane.INFORMATION_MESSAGE);
		else if (level==3)
			JOptionPane.showMessageDialog (null,"To win, you have to find and destroy \n"
					+ "5 submaines and 1 cargoship. Our intel from trustworthy spies \n "
					+ "tells the location of submarines - Look for them skipping every row.\n"
					+ "This is the new strategy of the enemy to cover more spaces by a single submarine.", 
					"HINT! Read it carefully...", JOptionPane.INFORMATION_MESSAGE);
	}

	//If the player give up, they loose but before that a dialog box appears to ask them if they are sure about the decision.
	public void Giveup ()
	{
		int input2 = JOptionPane.showConfirmDialog (null, "Are you sure you want to give up?",
				"No going back, if you click yes.", JOptionPane.YES_NO_OPTION);

		if(input2 == JOptionPane.YES_OPTION) {
			cdLayout.show (p_card, "5");//if they are sure about loosing then, they go to the loosing screen
			for (int m = 0 ; m < a.length ; m++)
				a [m].setIcon (createImageIcon ("sub0.png"));//sets the grid back to water
			//sets the points back to zero
			showPoint.setText("     Your Score: 0");
			points = 0;
			//sets the number of moves back to zero
			moves.setText("Your Moves: 0");
			Move = 0;
			//sets the progress bar back to zero
			pr.setValue(0);
			i=0;
			if(input2 == JOptionPane.NO_OPTION) {
				remove(input2);//if they don't want to give up then the dialog box just goes away
			}
		}
	}

	//Method to replay the game from level 1 (beginning)
	public void Replay()
	{
		cdLayout.show (p_card, "3");
		level = 0;
		levelUp();
	}

	// Button to FIRE and find out whether the player hits a ship or not
	public void Launch()
	{
		if(target!=-1){
			int x = target / col;
			int y = target % col;
			water[x][y]=sub[x][y];
			a [target].setIcon (createImageIcon ("sub" + sub [x] [y] + ".png"));
			target=-1;
			Move++;
			moves.setText("Your Moves: "+Move);
			//Points and Progress Bar Movements/changes if a ship or submarine is found
			if (sub[x][y]>=1 && sub[x][y]<=5) {
				points+=4;
				showPoint.setText("     Your Score: "+points);
				i+=5;
				pr.setValue (i);
			}       
			else if (sub[x][y]>=8 && sub[x][y]<=16) {
				points++;
				showPoint.setText("     Your Score: "+points); 
				i+=5;
				pr.setValue (i);
			}
			else 
				showPoint.setText("     Your Score: "+points);
			//inside the if clause, check for a win
			if (check ()) 
			{       
				next.setEnabled(true);
				showStatus ("You win!");
			}
			else
				showStatus ("Keep going");
		}
	}

	//code to handle the game
	public void Handle (int n) {
		int x = n / col;
		int y = n % col;
		target=n;
		a [n].setIcon (createImageIcon ("target.png"));
		showStatus ("(" + x + ", " + y + ")");  

	}

	public void actionPerformed (ActionEvent e)
	{  //moves between the screens
		if (e.getActionCommand ().equals ("s1")) 
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s2")) 
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s3")) 
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("s5"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s6"))
			System.exit (0);        
		else if (e.getActionCommand ().equals ("s4")) 
			levelUp(); 
		else if (e.getActionCommand ().equals ("giveup")) //if the player give up, they loose (takes to the give up method)
			Giveup();
		else if (e.getActionCommand ().equals ("play")) //takes the player to game screen
			cdLayout.show(p_card, "3");
		else if (e.getActionCommand ().equals ("Instruct")) //takes the player to the instruction screen
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("hint")) //takes to the hint button that shown hints for help
			Hint();
		else if (e.getActionCommand ().equals ("Reset")) //takes to start again method that resets the game
			StartAgain();
		else if (e.getActionCommand ().equals ("replay")) //to replay the game from level 1
			Replay();
		else if(e.getActionCommand().equals("save")) //takes to the save method so that the game can be played again
			save("file.txt");
		else if (e.getActionCommand().equals("open")) //takes to the open method so that the saved game can be opened again
			open("file.txt");
		else if (e.getActionCommand ().equals ("launch"))  //takes you to Launch method to FIRE and find out whether the player hits a ship or not
			Launch();
		else { //code to handle the game
			if(target==-1){
				int n = Integer.parseInt (e.getActionCommand ());
				Handle(n);
			}
		}
	}
}