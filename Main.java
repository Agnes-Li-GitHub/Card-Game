import java.awt.*;
import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Main program implements the application of a card game. 
 * It allows user to place bet. 
 * During the game, then can replace cards.
 * You have to run it via the run button in eclipse, not via command. 
 * The Image folder should be stored outside the src folder, same level as the .settings folder.
 * @author Li Sing Yee Agnes
 * @version 1.0
 * @since 2023-04-04
 */

public class Main implements ActionListener {
	Card i_card = new Card();
	public int bet_amount = 0;
	public String label_name = "";
	public JLabel[] JLabel_array = new JLabel[6]; 
	String initialize_filename= "";
	
	/**
	 * This is the main program, which only call the method go(). 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Main c = new Main();
		c.go();
	}

	/**
	 * This method is used to implement the layout of the card games, including
	 * various Swing elements inside a frame. 
	 */
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("A Simple Card Game");

		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(new GridLayout(5,1));
		frame.add(MainPanel);

		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		// Optional background color setting
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);

		JLabel label_Image1 = new JLabel();
		JLabel label_Image2 = new JLabel();
		JLabel label_Image3 = new JLabel();
		JLabel label_Image4 = new JLabel();
		JLabel label_Image5 = new JLabel();
		JLabel label_Image6 = new JLabel();
		JLabel_array[0] = label_Image1;
		JLabel_array[1] = label_Image2;
		JLabel_array[2] = label_Image3;
		JLabel_array[3] = label_Image4;
		JLabel_array[4] = label_Image5;
		JLabel_array[5] = label_Image6;
		
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);

		ImageIcon Image1 = new ImageIcon("Images/card_back.gif");
		ImageIcon Image2 = new ImageIcon("Images/card_back.gif");
		ImageIcon Image3 = new ImageIcon("Images/card_back.gif");
		ImageIcon Image4 = new ImageIcon("Images/card_back.gif");
		ImageIcon Image5 = new ImageIcon("Images/card_back.gif");
		ImageIcon Image6 = new ImageIcon("Images/card_back.gif");
		label_Image1.setIcon(Image1);
		label_Image2.setIcon(Image2);
		label_Image3.setIcon(Image3);
		label_Image4.setIcon(Image4);
		label_Image5.setIcon(Image5);
		label_Image6.setIcon(Image6);

		JButton btn_rpcard1 = new JButton("Replace Card 1");
		JButton btn_rpcard2 = new JButton("Replace Card 2");
		JButton btn_rpcard3 = new JButton("Replace Card 3");
		RpCardBtnPanel.add(btn_rpcard1);
		btn_rpcard1.setEnabled(false);
		RpCardBtnPanel.add(btn_rpcard2);
		btn_rpcard2.setEnabled(false);
		RpCardBtnPanel.add(btn_rpcard3);
		btn_rpcard3.setEnabled(false);	
		
		/**
		 * This is the Action Listener for replace button 1.
		 * @param ActionEvent e, which is a click 
		 * It helps to disable other replace button when necessary. 
		 * It also calls another method in Card to replace the image of the card.
		 */
		btn_rpcard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_rpcard1.setEnabled(false); 
				if (! btn_rpcard2.isEnabled() || ! btn_rpcard2.isEnabled()) {
					btn_rpcard2.setEnabled(false); 
					btn_rpcard3.setEnabled(false); 
				}
				label_Image4.setIcon(new ImageIcon(i_card.replace_card(0)));				
			}
		});

		/**
		 * This is the Action Listener for replace button 2. 
		 *  @param ActionEvent e, which is a click 
		 * It helps to disable other replace button when necessary. 
		 * It also calls another method in Card to replace the image of the card.
		 */
		btn_rpcard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_rpcard2.setEnabled(false); 
				if (! btn_rpcard1.isEnabled() || ! btn_rpcard3.isEnabled()) {
					btn_rpcard1.setEnabled(false); 
					btn_rpcard3.setEnabled(false); 
				}
				label_Image5.setIcon(new ImageIcon(i_card.replace_card(1)));
			}
		});

		/**
		 * This is the Action Listener for replace button 3. 
		 * @param ActionEvent e, which is a click
		 * It helps to disable other replace button when necessary. 
		 * It also calls another method in Card to replace the image of the card.
		 */
		btn_rpcard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_rpcard3.setEnabled(false);
				if (! btn_rpcard1.isEnabled() || ! btn_rpcard2.isEnabled()) {
					btn_rpcard1.setEnabled(false); 
					btn_rpcard2.setEnabled(false); 
				}
				label_Image6.setIcon(new ImageIcon(i_card.replace_card(2)));
			}
		});

		JLabel label_bet = new JLabel("Bet: $");
		JTextField txt_inputbet = new JTextField(10);
		JButton btn_start = new JButton("Start");
		JButton btn_result = new JButton("Result");
		ButtonPanel.add(label_bet);
		ButtonPanel.add(txt_inputbet);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);
		btn_result.setEnabled(false);

		JLabel label_info = new JLabel("Please place your bet! Amount of money you have: $");
		JLabel label_money = new JLabel("100");
		InfoPanel.add(label_info);
		InfoPanel.add(label_money);

		JMenuBar menuBar = new JMenuBar(); 
		JMenu menu = new JMenu ("Control"); 
		JMenuItem menuItem = new JMenuItem("Exit"); 
		menu.add(menuItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		frame.setSize(400, 700);
		frame.setVisible(true);

		/**
		 * This is the Action Listener for exit button.
		 * @param ActionEvent e, which is a click 
		 */
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		/**
		 * This is the Action Listener for start button.
		 * @param ActionEvent e, which is a click 
		 * It changes the text and starts the game by calling 3 methods in Card
		 * shuffle_card(), initialize_dealer_card() and initialize_player_card. 
		 */
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				label_money.setText(txt_inputbet.getText());
				bet_amount = Integer.parseInt(txt_inputbet.getText());
				// need to be positive 
				
				label_info.setText("Your current bet is: $" + bet_amount);
				label_money.setText(" Amount of money you have: $" + i_card.player_amount);
				btn_rpcard1.setEnabled(true);
				btn_rpcard2.setEnabled(true);
				btn_rpcard3.setEnabled(true);
				btn_result.setEnabled(true);
				btn_start.setEnabled(false);
				i_card.shuffle_card();
				i_card.initialize_dealer_card();
				// player card in array 3,4,5
				for (int i=3;i<6;i++) {
					initialize_filename = i_card.initialize_player_card(i);	
					JLabel_array[i].setIcon(new ImageIcon(initialize_filename));
				}				
			}
		});

		/**
		 * This is the Action Listener for result button.
		 * @param ActionEvent e, which is a click 
		 * It changes the text and display the result by calling the method result() in Card. 
		 * Then reset everything, just like the initial setting. 
		 *  
		 */
		// event listener for result button
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dealer card 
				for (int i=0;i<3;i++) {
					initialize_filename = "Images/card_" + i_card.dealer_deck[i] + ".gif";
					JLabel_array[i].setIcon(new ImageIcon(initialize_filename));
				}
				String winner = i_card.result();
				if (winner == "player") {
					JOptionPane.showMessageDialog(frame, "Congrualtion! You win this round!");
					i_card.player_amount += bet_amount;
				}
				else {
					JOptionPane.showMessageDialog(frame, "Sorry! The dealer wins this round!");
					i_card.player_amount -= bet_amount;
				}
				
				if (i_card.player_amount <= 0) {
					JOptionPane.showMessageDialog(frame, "Game over! You have no more money! Please start a new game!");
					label_info.setText("You have no more money! Please start a new game!");
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
					btn_result.setEnabled(false);
					btn_start.setEnabled(false);
				}
				else { // continue the game
					btn_rpcard1.setEnabled(true);
					btn_rpcard2.setEnabled(true);
					btn_rpcard3.setEnabled(true);
					btn_start.setEnabled(true);
					btn_result.setEnabled(true);
				}
				bet_amount = 0;	
				
				// clear things
				label_info.setText("Please place your bet! Amount of money you have: $" + i_card.player_amount);
				label_money.setText("");
				txt_inputbet.setText("");
				Arrays.fill(i_card.player_deck, "");
				Arrays.fill(i_card.dealer_deck, "");
				i_card.all_card.clear();
				i_card.current_card = 0;
				label_Image1.setIcon(new ImageIcon("Images/card_back.gif"));
				label_Image2.setIcon(new ImageIcon("Images/card_back.gif"));
				label_Image3.setIcon(new ImageIcon("Images/card_back.gif"));
				label_Image4.setIcon(new ImageIcon("Images/card_back.gif"));
				label_Image5.setIcon(new ImageIcon("Images/card_back.gif"));
				label_Image6.setIcon(new ImageIcon("Images/card_back.gif"));
			}
		});
	}

	/**
	 * This is the actionPerformed method. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}