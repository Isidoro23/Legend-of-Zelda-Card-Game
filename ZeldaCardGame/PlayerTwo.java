import java.util.ArrayList;
public class PlayerTwo extends Player {
    public PlayerTwo() {
        obj.shuffle(deck);
        for (int i = 0; i < 5; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
    }

    public void draw() {
        for (int i = 0; i < 2; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
    }

    public void summon(Player opponent) {
        for (int i = 0; i < hand.size(); i++) {
            if (rupees >= hand.get(i).cost) {
                System.out.println();
                System.out.println("Player two has summoned: " + hand.get(i).name);
                System.out.println();
                if (hand.get(i).name != "Nami" && hand.get(i).name != "TriFECTA" && hand.get(i).name != "Bow of Ra" && hand.get(i).name != "Master Sword") {
                    field.add(hand.get(i));
                    hand.remove(i);
                } else {
                    if (hand.get(i).name == "Nami") {
                        System.out.println("Player two has used a fairy to regain health and draw cards.");
                        System.out.println();
                        for (int j = 0; j < 3; j++) { //draw 3 cards.
                            hand.add(deck.get(j));
                            deck.remove(j);
                        }
                        playerHealth = playerHealth + 5; //give health.
                        System.out.println("Player two's health is now: " + playerHealth);
                        System.out.println();
                    }
                    if (hand.get(i).name == "Bow of Ra") {
                        if (opponent.field.size() != 0) { //if opponent has no monsters on field, then just do direct damage.
                            System.out.println("Player two has chosen the Bow of Ra to strike down your enemies.");
                            System.out.println();
                            System.out.println("Enemy's field: ");
                            for (int j = 0; j < opponent.field.size(); j++){
                                System.out.println(j + " = " + opponent.field.get(j).name);
                            }

                            opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
                            System.out.println("Player one's health is now: " + opponent.getPlayerHealth());
                        } else {
                            opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
                            System.out.println("Player one's health is now: " + opponent.getPlayerHealth());
                        }
                    }
                    if (hand.get(i).name == "Master Sword") {
                        if(field.size() == 0)
                        {
                            System.out.println("Player 2 has wasted rupees");
                        }
                        else
                        {
                            System.out.println();
                            for (int j = 0; j < 1; j++) {
                                field.get(j).attackDmg = field.get(j).attackDmg + 4;
                                field.get(j).unitHealth = field.get(j).unitHealth + 2;
                            }
                        }

                    }
                    if (hand.get(i).name == "TriFECTA") {
                        System.out.println("A Triforce piece has been played by player two!");
                        System.out.println();
                        int counter = 0;
                        counter++;              //counts each time a triforce piece is played on field. If counter = 3 then win.
                        if (counter == 3) {
                            opponent.setPlayerHealth(0);
                        }

                    } else {
                        field.add(hand.get(i));
                        rupees = rupees - hand.get(i).cost;
                        hand.remove(i);
                    }
                }
            }
        }
    }

    public void attack(Player opponent) {
        ArrayList<Card> temp = new ArrayList<>();
        Card name;
        Card ename;
        Card change;
        int attackDmg;
        int eattackDmg;
        int unitHealth;
        int eunitHealth;

        /* for (Card element : field) {
        int unitNum;
        int unitNum2;
        if (element.name == "Nami") {
        for (int i = 0; i < 3; i++) { //draw 3 cards.
        hand.add(deck.get(i));
        deck.remove(i);
        }
        System.out.println();
        System.out.println("A fairy was used and restored 5 HP to player 2.");
        playerHealth = playerHealth + 5; //give health.
        field.remove(element);
        }
        if (element.name == "TriFECTA") {
        int counter = 0;
        counter++; 
        System.out.println();
        System.out.println("A triforce piece has been played by player two.");
        //counts each time a triforce piece is played on field. If counter = 3 then win.
        if (counter == 3) 
        {
        opponent.setPlayerHealth(0);
        }

        }
        if (element.name == "Bow of Ra") {
        if (opponent.field != null) {
        System.out.println();
        System.out.println("Player two's Bow of Ra strikes your enemy.");
        opponent.field.remove(0);
        opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
        System.out.println("Player one's health is: " + opponent.playerHealth);
        field.remove(element);
        } else {
        //if opponent has no monsters on field, then just do direct damage.
        opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
        System.out.println("Player one's health is: " + opponent.playerHealth);
        field.remove(element);
        }
        }
        if (element.name == "Master Sword") { //enhance unit of choice's life and attack dmg.
        System.out.println();
        System.out.println("Player two's " + field.get(0).name + " has had its abilities enhanced."); 
        field.get(0).attackDmg = field.get(0).attackDmg + 4;
        field.get(0).unitHealth = field.get(0).unitHealth + 2;
        field.remove(element);
        }
        } */

        for (int i = 0; i < field.size(); i++) 
        {

            System.out.println("Player two's " + field.get(i).name + " is attacking!");
            System.out.println();
            name = field.get(i);
            attackDmg = name.getAttackDmg();

            if(opponent.field.size() == 0)
            {
                System.out.println();
                System.out.println("Player 2 is attacking player one directly");
                opponent.setPlayerHealth(opponent.getPlayerHealth() - attackDmg);
                System.out.println("Player one's health is: " + opponent.playerHealth);
            }
            else
            {
                System.out.println("Player one's health is: " + opponent.playerHealth);
                unitHealth = name.getUnitHealth();

                ename = opponent.field.get(i);
                eunitHealth = ename.getUnitHealth();
                eattackDmg = ename.getAttackDmg();

                eunitHealth = eunitHealth - attackDmg;
                unitHealth = unitHealth - eattackDmg;

                if(eunitHealth <= 0)
                {
                    System.out.println();
                    System.out.println("Player one's unit: " + ename.name + " was killed!");
                    opponent.field.remove(i);
                }
                else
                {
                    System.out.println();
                    System.out.println("Player one's unit: " + ename.name + " was attacked!");
                    ename.setUnitHealth(eunitHealth);
                }

                if(unitHealth <= 0)
                {
                    System.out.println();
                    System.out.println("Player two's unit: " + field.get(i).name + " has been killed!");
                    field.remove(i);
                }
                else
                {
                    name.setUnitHealth(unitHealth);
                }
            }

        }

    }
}
