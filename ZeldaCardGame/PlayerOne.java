import java.util.ArrayList;
import java.util.Scanner;

public class PlayerOne extends Player
{  
    Scanner scan = new Scanner(System.in); 
    public PlayerOne() {
        obj.shuffle(deck);
        for (int i = 0; i < 5; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
        rupees = 1;
    }

    //responsible for drawing cards each turn.
    public void draw() {
        for (int i = 0; i < 2; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
    }

    //responsible for putting units on field each turn.
    public void summon(Player opponent) {
        int place;
        int strategy;
        int unitCost;
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + " = " + hand.get(i).name);
        }

        System.out.println("Your Rupees: " + rupees);

        System.out.println("Do you want to play any cards? '1' for yes, '2' for no"); 
        strategy = scan.nextInt();
        if (strategy == 1) {
            while (strategy == 1) { 
                System.out.println("Which card will you play? "); /*if cards are played, take from deck,  
                move to hand. */
                place = scan.nextInt();  
                if (rupees >= hand.get(place).cost) {

                    unitCost = hand.get(place).cost;

                    rupees = rupees - unitCost;

                    if (hand.get(place).name != "Nami" && hand.get(place).name != "TriFECTA" && hand.get(place).name != "Bow of Ra" && hand.get(place).name != "Master Sword") {
                        field.add(hand.get(place));
                        hand.remove(place);
                    } else {
                        if (hand.get(place).name == "Nami") {
                            System.out.println("You have used a fairy to regain health and draw cards.");
                            System.out.println();
                            for (int i = 0; i < 3; i++) { //draw 3 cards.
                                hand.add(deck.get(i));
                                deck.remove(i);
                            }
                            playerHealth = playerHealth + 5; //give health.
                            System.out.println("Player one's health is now: " + playerHealth);
                            System.out.println();
                            System.out.println("Your hand.");
                            for (int i = 0; i < hand.size(); i++) {
                                System.out.println(i + " = " + hand.get(i).name);
                            }
                            System.out.println("Your rupees: " + rupees);
                        }
                        if (hand.get(place).name == "Bow of Ra") {
                            if (opponent.field != null) { //if opponent has no monsters on field, then just do direct damage.
                                System.out.println("You have chosen the Bow of Ra to strike down your enemies.");
                                System.out.println();
                                System.out.println("Enemy's field: ");
                                for (int i = 0; i < opponent.field.size(); i++){
                                    System.out.println(i + " = " + opponent.field.get(i).name);
                                }
                                System.out.println("What unit would you like to execute? ");
                                int unitNum = scan.nextInt();

                                opponent.field.remove(unitNum);
                                opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
                                System.out.println("Player two's health is now: " + opponent.getPlayerHealth());
                            } else {
                                opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
                                System.out.println("Player two's health is now: " + opponent.getPlayerHealth());
                            }
                        }
                        if (hand.get(place).name == "Master Sword") {
                            int unitNum2;
                            System.out.println();
                            System.out.println("Your field. ");
                            for (int i = 0; i < field.size(); i++) {
                                System.out.println(i + " = " + field.get(i).name);
                            }
                            System.out.println();
                            System.out.println("Which unit's abilities do you want to enhance? ");
                            unitNum2 = scan.nextInt();
                            field.get(unitNum2).attackDmg = field.get(unitNum2).attackDmg + 4;
                            field.get(unitNum2).unitHealth = field.get(unitNum2).unitHealth + 2;
                            System.out.println(field.get(unitNum2).name + " 's abilities were enhanced.");
                        }
                        if (hand.get(place).name == "TriFECTA") {
                            System.out.println("A Triforce piece has been played by player one!");
                            System.out.println();
                            int counter = 0;
                            counter++;              //counts each time a triforce piece is played on field. If counter = 3 then win.
                            if (counter == 3) {
                                opponent.setPlayerHealth(0);
                            }
                        }
                    }
                } else {
                    System.out.println("You have not enough minerals."); //the starcraft reference.
                }
                System.out.println();
                System.out.println("Would you like to summon any more? '1' for yes, '2' for no");
                strategy = scan.nextInt();
            }
        }
    }

    //responsible for printing fields and attacking opponent.
    public void attack(Player opponent) {
        int yourUnitNum;
        int opponentUnitNum;
        int yourAttackDmg;
        int opponentAttackDmg;
        int yourUnitHealth;
        int opponentUnitHealth;

        Card name;
        Card opponentName;
        Card change;

        ArrayList<Card> temporary = new ArrayList<>();

        //checks for the items.
        /* for (Card element : field) {
        int unitNum;
        int unitNum2;
        if (element.name == "Nami") {
        System.out.println("You have used a fairy to regain health and draw cards.");
        System.out.println();
        for (int i = 0; i < 3; i++) { //draw 3 cards.
        hand.add(deck.get(i));
        deck.remove(i);
        }
        playerHealth = playerHealth + 5; //give health.

        }
        if (element.name == "TriFECTA") {
        System.out.println("A Triforce piece has been played by player one!");
        System.out.println();
        int counter = 0;
        counter++;              //counts each time a triforce piece is played on field. If counter = 3 then win.
        if (counter == 3) {
        opponent.setPlayerHealth(0);
        }
        }
        if (element.name == "Bow of Ra") {
        if (opponent.field != null) { //if opponent has no monsters on field, then just do direct damage.
        System.out.println("You have chosen the Bow of Ra to strike down your enemies.");
        System.out.println();
        System.out.println("Enemy's field: ");
        for (int i = 0; i < opponent.field.size(); i++){
        System.out.println(i + " = " + opponent.field.get(i).name);
        }
        System.out.println("What unit would you like to execute? ");
        unitNum = scan.nextInt();

        opponent.field.remove(unitNum);
        opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);

        } else {
        opponent.setPlayerHealth(opponent.getPlayerHealth() - 7);
        System.out.println("Player two's health is now: " + opponent.getPlayerHealth());

        }
        }
        if (element.name == "Master Sword") { //enhance unit of choice's life and attack dmg.
        System.out.println();
        System.out.println("Your field. ");
        for (int i = 0; i < field.size(); i++) {
        System.out.println(i + " = " + field.get(i).name);
        }
        System.out.println();
        System.out.println("Which unit's abilities do you want to enhance? ");
        unitNum2 = scan.nextInt();
        field.get(unitNum2).attackDmg = field.get(unitNum2).attackDmg + 4;
        field.get(unitNum2).unitHealth = field.get(unitNum2).unitHealth + 2;
        field.remove(element);
        }
        } */

        //starts the unit attacking process.
        if (field.size() > 0){
            System.out.println();
            System.out.println("Your field. ");         //displays field.
            for (int i = 0; i < field.size(); i++) {
                System.out.println(i + " = " + field.get(i).name);
            }
            System.out.println();
            System.out.println("Opponent's field. ");   //displays opponents field.
            System.out.println("0 = Opponent's direct health. ");   //the index 0 counts as the opponents direct health in the opponent's 'field'.
            System.out.println();
            for (int i = 0; i < opponent.field.size(); i++){
                System.out.println(i+1 + " = " + opponent.field.get(i).name);
            }
            System.out.println();

            for (int i = 0; i < field.size(); i++) {
                System.out.println("Who would you like to attack? Enter the number that corresponds with your opponent's field's units. ");
                opponentUnitNum = scan.nextInt();   //pick your attacker's victim.

                if (opponentUnitNum == 0) {

                    System.out.println("Player one's " + field.get(i).name + " is attacking opponent directly!");
                    yourAttackDmg = field.get(i).getAttackDmg();

                    opponent.setPlayerHealth(opponent.getPlayerHealth() - yourAttackDmg);

                    System.out.println();
                    System.out.println("Opponent's health is now: " + opponent.getPlayerHealth());
                    System.out.println();

                    /*System.out.println("Your field: ");

                    for (int i = 0; i < field.size(); i++) {
                    System.out.println(i + " = " + field.get(i) + " | ");
                    }
                    System.out.println("Opponent's field. ");
                    System.out.println("0 = Opponent's direct health. ");
                    for (int i = 0; i < opponent.field.size(); i++){
                    System.out.println(i+1 + " = " + opponent.field.get(i) + " | ");
                    }
                    System.out.println("Who would you like to attack with? Enter the number that corresponds with your field's units. ");
                    yourUnitNum = scan.nextInt();
                    System.out.println("Who would you like to attack? Enter the number that corresponds with your opponent's field's units. ");
                    opponentUnitNum = scan.nextInt(); */
                } else {
                    opponentUnitNum--;

                    System.out.println("Player one's " + field.get(i).name + " is demolishing player two's " + opponent.field.get(opponentUnitNum).name);

                    yourAttackDmg = field.get(i).getAttackDmg();
                    yourUnitHealth = field.get(i).getUnitHealth();

                    opponentName = opponent.field.get(opponentUnitNum);
                    opponentUnitHealth = opponentName.getUnitHealth();
                    opponentAttackDmg = opponentName.getAttackDmg();

                    opponentUnitHealth = opponentUnitHealth - yourAttackDmg;
                    yourUnitHealth = yourUnitHealth - opponentAttackDmg;

                    if (opponentUnitHealth <= 0) {
                        opponent.field.remove(opponentUnitNum);
                    } else {
                        opponentName.setUnitHealth(opponentUnitHealth);
                    }
                    if (yourUnitHealth <= 0) {
                        field.remove(i);
                    } else {
                        field.get(i).setUnitHealth(yourUnitHealth);
                    }
                    System.out.println();
                    System.out.println("Your Field: ");
                    for (int j = 0; i < field.size(); i++) {
                        System.out.println(i + " = " + field.get(i).name);
                    }
                    System.out.println();
                    System.out.println("Opponent's field. ");
                    System.out.println("0 = Opponent's direct health. ");
                    for (int k = 0; i < opponent.field.size(); i++){
                        System.out.println(i+1 + " = " + opponent.field.get(i).name);
                    }
                    System.out.println();
                }
            }

        }
    }
}
