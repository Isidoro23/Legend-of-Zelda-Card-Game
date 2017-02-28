

public class Card 
{
   public int attackDmg;        //the things units have that not all cards have.
   public int unitHealth; 
   
   public int probability;
   public int cost; 
   public String name;
   public int quantity;
    
   public Card() {
       probability = 1;
       cost = 1;
       name = "help";
       quantity = 40;
       unitHealth =1;
       attackDmg = 1;
   }
   
    public int getUnitHealth() {
        return unitHealth;
     }

    public void setUnitHealth(int health) {
        unitHealth = health;
     }

    public int getAttackDmg() {
        return attackDmg;
     }

    public String getName() {
        return name;
     }
}
