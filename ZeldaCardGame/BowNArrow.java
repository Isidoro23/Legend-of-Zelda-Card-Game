

public class BowNArrow extends Card
{

    
    public BowNArrow() {
        cost = 8;
        name = "Bow of Ra";
        quantity = 4;
    }
    
    public String effect(Player opponent) {
        int opponentHP = opponent.getPlayerHealth();
        opponentHP = opponentHP - 7;
        return "Opponents new Health is: " + opponentHP;
    }
}
