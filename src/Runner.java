
public class Runner {
	public static void main(String [] args) throws InterruptedException
	{
		
	
    Warrior Pink_Guy = new Warrior(1000, 25, (int)(Math.random() * 20 + 1), "Pink Guy", "Normal");
    Warrior Jeremy = new Warrior(1000, 25, (int)(Math.random() * 20 + 1), "Weeaboo", "Weeaboo");
    System.out.println("The " + Pink_Guy.getType() + " Pink Guy has " + Pink_Guy.getHP() + " HP, " + Pink_Guy.getMP() + " MP, and deals " + Pink_Guy.getDMG() + " damage");
    System.out.println("The "  + Jeremy.getType() + " Jeremy has " + Jeremy.getHP() + " HP, " + Jeremy.getMP() + " MP, and deals " + Jeremy.getDMG() + " damage");
    Character.userBattle(Pink_Guy, Jeremy);
	}
	
}
