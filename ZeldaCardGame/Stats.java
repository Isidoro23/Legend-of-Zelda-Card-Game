import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Stats extends JComponent
{
    public void createInstructions() {
     JFrame frame = new JFrame();   
     frame.setSize(750,515);
     frame.setTitle("Unit Stats and Instructions");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     Stats component = new Stats();
     frame.add(component);
     
     frame.setVisible(true);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Unit Stats: ", 10, 30);
        g2.drawString("Link: Attack - 6; Health - 5; Cost - 7;", 10, 50);
        g2.drawString("Zelda: Attack - 3; Health - 7; Cost - 6;", 10, 70);
        g2.drawString("Ganondorf: Attack - 6; Health - 10; Cost - 9;", 10, 90);
        g2.drawString("Goron: Attack - 3; Health - 5; Cost - 5;", 10, 110);
        g2.drawString("Zora: Attack - 4; Health - 4; Cost - 4;", 10, 130);
        g2.drawString("Skeleton: Attack - 3; Health - 1; Cost - 1;", 10, 150);
        g2.drawString("Item Properties: ", 10, 200);
        g2.drawString("Master Sword: Cost - 5; Effect: Your units on field get +4 attack and +2 health.", 10, 220);
        g2.drawString("Fairy: Cost - 6; Effect: Player Health + 5 and draw 3 cards.", 10 , 240);
        g2.drawString("Bow of Ra: Cost - 8; Effect: Kill an opponent's unit and opponent's health - 7.", 10, 260);
        g2.drawString("Instructions: ", 10, 290);
        g2.drawString("You and another player have stumbled upon the accursed decks of Hyrule while watering a garden.", 10, 310);
        g2.drawString("An ancient evil lives within the deck and commands the two nearest mortals to battle to the death in the Legend of Zelda Card Game.", 10, 330);
        g2.drawString("The loser's soul is banished to the void, only to be released when another soul is consumed in its place.", 10, 350);
        g2.drawString("After a match, the ancient deck retreats into a place of unknown origin and awaits patiently for the next victims.", 10, 370);
        g2.drawString("Units and items cost rupees; for every turn, you gain nth turn rupees. I.e. round 3 will award 3 rupees.", 10, 390);
        g2.drawString("There is no limit to the amount of rupees you may have, nor a limit to the units you can have on the field.", 10, 410);
        g2.drawString("A forsaken, powerful spirit has said to have left behind three components to a sacred tri-force.", 10, 430);
        g2.drawString("It is rumored that the lucky one who plays all three of these rare treasures onto the field will immediately gain victory.", 10, 450);
    }
}
