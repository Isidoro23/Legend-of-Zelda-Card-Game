import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
    
    //Fills a players deck with 40 cards.
    public ArrayList<Card> fillDeck(ArrayList<Card> cards) {
        for (int i = 1; i <= 2; i++) {
            cards.add(new Ganondorf());
        }
        for (int i = 1; i <= 3; i++) {
            cards.add(new TriForce());
            cards.add(new Zelda());
        }
        for (int i = 1; i <=5; i++) {
            cards.add(new Link());
            cards.add(new Fairy());
        }
        for (int i = 1; i <=4; i++) {
            cards.add(new Goron());
            cards.add(new Zora());
            cards.add(new MasterSword());
            cards.add(new BowNArrow());
        }
        for (int i = 1; i <=6; i++) {
            cards.add(new Skeleton());
        }
        return cards;
    }
    
    //Shuffles a players deck. Returns the newly shuffled deck.
    public ArrayList<Card> shuffle(ArrayList<Card> cards) {
        Random random = new Random();
        Card oldValue;
        Card newValue;
        int newPosition;
        for (int i = 0; i < 39; i++) {
            newPosition = random.nextInt(40);
            oldValue = cards.get(i);
            cards.set(i, cards.get(newPosition));
            cards.set(newPosition, oldValue);
        }
        return cards;
    }
    
    public static void main(String[] args)
    {
        //test
        Deck test = new Deck();
        ArrayList<Card> name = new ArrayList<>();
        test.fillDeck(name);
        test.shuffle(name);
        System.out.println(name);
    }
    
}