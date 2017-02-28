import java.util.Scanner;
public class Turns
{
    PlayerOne player1 = new PlayerOne();
    PlayerTwo player2 = new PlayerTwo();
    boolean hasWonP1 = false;
    boolean hasWonP2 = false;
    Scanner scan = new Scanner(System.in);

    public void nextTurn() {
        int turnNum = 1;

        while (hasWonP1 == false && hasWonP2 == false) {
            playerOneTurn();
            playerTwoTurn();
            turnNum++;
            player1.rupees = player1.rupees + turnNum;
            player2.rupees = player2.rupees + turnNum;
        }

        if (hasWonP1 == true) {
            TriforceDrawer winReward = new TriforceDrawer();
            winReward.drawTri();
        } 
        if (hasWonP2 == true){
            DarkTriViewer loseReward = new DarkTriViewer();
            loseReward.drawDark();
        }

    }

    public void playerOneTurn() {
        int response;
        Stats instructions = new Stats();
        
        System.out.println("Player one's turn has started.");
        
        System.out.println("Want instructions? '1' for yes, '2' for no.");
        response = scan.nextInt();
        
        if (response == 1) {
            instructions.createInstructions();
        }
        
        player1.draw();
        player1.summon(player2);
        player1.attack(player2);
        
        if (player2.getPlayerHealth() <= 0) {
            hasWonP1 = true;
        }
    }

    public void playerTwoTurn() {
        
        System.out.println("Player two's turn has started.");
        
        player2.draw();
        player2.summon(player1);
        player2.attack(player1);
        
        if (player1.getPlayerHealth() <= 0) {
            hasWonP2 = true;
        }
    }

}
