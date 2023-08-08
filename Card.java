import java.util.*;
import java.util.Collections;
/**
 * Here we stores the details of the 52 cards, the current player cards and dealer cards.
 * @author Agnes
 *
 */
public class Card {
	public List<String> all_card = new ArrayList<String>();
	public String[] dealer_deck = new String[3]; 
	public String[] player_deck = new String[3]; 
	public int current_card = 0;
	public String card_filename = "";
	public int player_amount = 100;
	
	/**
	 * This method is to add the card into the array list all_card. 
	 * Then shuffle all the cards.
	 */
	public void shuffle_card() {
		String value = "";
		for (int i=1; i<5; i++) {
			for (int j=1; j<14; j++) {
				value = "" + i + j;
				all_card.add(value);			}
		}
		Collections.shuffle(all_card);
	}
	
	/**
	 * This method is to give cards to dealer and add it to the array dealer_deck.
	 */
	public void initialize_dealer_card(){
		for (int i = 0; i<=2; i++) {
			dealer_deck[i] = all_card.get(i);
			current_card += 1;
		}
	}
	
	/**
	 * This method is to give cards to player and add it to the array player_deck.
	 * @param i The value i-3 is the array index of the player_deck.
	 * @return String This returns the path of the card image
	 */
	public String initialize_player_card(int i){
		player_deck[i-3] = all_card.get(current_card);
		card_filename = "Images/card_" + all_card.get(current_card) + ".gif";
		current_card += 1;
		return card_filename;		
	}

	/**
	 * This method is to replace the cards by getting the next card and change the path.
	 * @param i This is for access the player_deck index.
	 * @return String This returns the path of the card image
	 */
	public String replace_card(int i) {
		player_deck[i] = all_card.get(current_card);
		card_filename = "Images/card_" + all_card.get(current_card) + ".gif";
		current_card += 1;
		return card_filename;
	}

	/**
	 * This method is to calculate the result. 
	 * @return String This returns the winner, either player or dealer
	 */
	public String result() {
		// case 1 - counting special cards JQK
		String winner = "";
		int player_count = 0;
		int dealer_count = 0;
		for (int i=0; i<3; i++) {
			if (player_deck[i].length() == 3) {
				player_count += 1;
			}
		}
		for (int i=0; i<3; i++) {
			if (dealer_deck[i].length() == 3) {
				dealer_count += 1;
			}
		}
		if (dealer_count > player_count) {
			winner = "dealer";
			return winner;
		}
		else if (dealer_count < player_count) {
			winner = "player";
			return winner;
		}
		player_count = dealer_count = 0;

		// case 2
		for (int i=0; i<3; i++) {
			if (player_deck[i].length() == 2) {
				player_count += Integer.parseInt(player_deck[i].substring(player_deck[i].length() - 1));
			}
		}
		player_count = player_count % 10;
		for (int i=0; i<3; i++) {
			if (dealer_deck[i].length() == 2) {
				dealer_count += Integer.parseInt(dealer_deck[i].substring(dealer_deck[i].length() - 1));
			}
		}
		dealer_count = dealer_count % 10;
		if (dealer_count > player_count) {
			winner = "dealer";
			return winner;
		}
		else if (dealer_count < player_count) {
			winner = "player";
			return winner;
		}
		else if (dealer_count == player_count) {
			winner = "dealer";
			return winner;
		} 
		return winner;
	}
}