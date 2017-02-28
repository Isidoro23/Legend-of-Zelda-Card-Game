import java.util.ArrayList;


public class Player 
{
   public int playerHealth;
   public int rupees;
   public Deck obj = new Deck();
   public ArrayList<Card> deck = new ArrayList<>();
   public ArrayList<Card> hand = new ArrayList<>();
   public ArrayList<Card> field = new ArrayList<>();
   
    public Player() {
        playerHealth = 30;
        rupees = 1;
        obj.fillDeck(deck);
    }
    
    public int getRupee() {
        return rupees;
    }
    
    public void setRupee(int something) {
        rupees = something;
    }
    
     public int getPlayerHealth() {
       return playerHealth;
    }
    
    public void setPlayerHealth(int health) {
       playerHealth = health;
    }
   
}
