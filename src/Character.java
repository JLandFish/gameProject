import java.util.Scanner;
public abstract class Character {
	protected int HP;
	protected int MP;
	protected int Damage;
	protected String Name;
	protected String Type;
	
	//test this thing
	public Character(int hp, int mp, int damage, String name, String type)
	{
		HP = hp;
		MP = mp;
		Damage = damage;
		Name = name;
		Type = type;
	}
	public abstract int getHP();
	public abstract int getMP();
	public abstract int getDMG();
	public abstract String getType();
	public abstract String getName();
	
	public static void autoBattle(Character warrior1, Character warrior2) throws InterruptedException{
		  do{
			  System.out.println(warrior1.getName() +" begins the fight against "+warrior2.getName());
			int totalDMG1 = warrior1.Damage + warrior1.getDMG() + (int)(Math.random() * 5 + 1);
			warrior2.HP = warrior2.HP - totalDMG1;
            Thread.sleep(1500);
			System.out.println(warrior1.getName() +" does "+ totalDMG1 +" damage to "+
			warrior1.getName() +" and "+ warrior2.getName() +" has "+ warrior2.getHP() +" left.");
			Thread.sleep(1500);
			int totalDMG2 = warrior2.Damage + warrior2.getDMG() + (int)(Math.random() * 5 + 1);
			warrior1.HP = warrior1.HP - totalDMG2;
			Thread.sleep(1500);
			System.out.println(warrior2.getName() +" does "+ totalDMG2 +" damage to "+ 
			warrior1.getName() +" and "+ warrior1.getName() +" has "+ warrior1.getHP() +" left.");
						  }while(warrior1.getHP() >= 1 && warrior2.getHP() >= 1);
			  if(warrior1.getHP() < 1)
			    System.out.println(warrior1.getName() +" has lost the fight");
			  else
			    System.out.println(warrior2.getName() +" has lost the fight");
			  }
	
	 public static void userBattle(Character w1, Character w2) throws InterruptedException
	 {
		 Scanner sc = new Scanner(System.in);
		 do
		 {
			System.out.println("Hello User, type out 'start' to commence the battle, otherwise type out exit to quit the program");
			String Response = sc.next();
			
			if(Response.equalsIgnoreCase("start"))
			{
				do{
				
				System.out.println("Player 1 what would you like to do, type '1' for basic attack, '2' to regain 10 HP, '3' to regen 5 mp, '4' to use your special attack");
				int w1Decision = sc.nextInt();
				System.out.println(w2.getName() + " is the 2nd player");
				System.out.println("Player 2 what would you you like to do, type '1' for basic attack, '2' to regain 10 HP, '3' to regen 5 mp, '4' to use your special attack");
                int w2Decision = sc.nextInt();
				if(w1Decision == 1)
				{
					
					w1.Damage += 10;
					int w1totalDMG = w1.Damage + w1.getDMG();
					w2.HP = w2.HP - w1totalDMG;
				   
					System.out.println(w1.getName()+ " deals " + w1totalDMG);
					System.out.println(w2.getName() + " health is now " + w2.HP);
				
					
				}
				
					
				if(w1Decision == 2)
				{
					w1.HP += 10;
					System.out.println(w1.getName() + " heals 10 HP" );
				}
				if(w1Decision == 3)
				{
					w1.MP += 5;
					System.out.println(w1.getName() + " heals 10 MP") ;
				}
				if(w1Decision == 4 && w1.MP > 10)
				{
					w1.Damage += 30;
					int w1totalDMG = w1.Damage + w1.getDMG();
					w1.MP -= 10;
					w2.HP = w2.HP - w1totalDMG;
					System.out.println(w1.getName() + "unleashes its special attack and deals " + w1totalDMG + " your opponents health is now " + w2.HP);
				}
				  if(w1Decision == 4 && w1.MP < 10)
				    {
				    	System.out.println(w1.getName() + " is not strong enough to complete this action");
				    }
				 if(w2Decision == 1)
				    {
				    	w2.Damage += 10;
						int w2totalDMG = w2.Damage + w2.getDMG();
						w1.HP = w1.HP - w2totalDMG;
						System.out.println(w2.getName() + " deals "+ w2totalDMG);
						System.out.println(w1.getName() + " health is now " + w1.HP);
				    }
				    if(w2Decision == 2)
				    {

						w2.HP += 10;
						System.out.println(w2.getName() + " heals 10 HP");
				    	
				    }
				    if(w2Decision == 3)
				    {
				    	w2.MP += 5;
						System.out.println(w2.getName() + " heals 10 MP");
				    	
				    }
				    if(w2Decision == 4 && w2.MP > 10)
				    {
						w2.Damage += 30;
						int w2totalDMG = w1.Damage + w1.getDMG();
						w2.MP -= 10;
						w1.HP = w1.HP - w2totalDMG;
						System.out.println(w2.getName() + "unleashes its special attack and deals " + w2totalDMG + " your opponents health is now " + w1.HP);
					
				    	
				    }
				    if(w2Decision == 4 && w2.MP < 10)
				    {
				    	System.out.println(w2.getName() + " is not strong enough to complete this action");
				    }
				}while(w1.getHP() >= 1 && w2.getHP() >= 1);
				if(w1.getHP() < 1)
			    System.out.println(w1.getName() +" has lost the fight");
			  else
			    System.out.println(w2.getName() +" has lost the fight");
			}
			else
			System.out.println("Exiting program...");
			System.exit(0);
			 
		 }while(w1.getHP() >= 1 && w2.getHP() >= 1);
		  
			  }
	 }
	 
		
	


